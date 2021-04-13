/*
 * Copyright 2021 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.smithy.plugin;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.wso2.lsp4intellij.IntellijLanguageClient;
import software.amazon.smithy.model.node.Node;
import software.amazon.smithy.model.node.NodeMapper;
import software.amazon.smithy.utils.IoUtils;
import software.amazon.smithy.utils.ListUtils;

/**
 * After IntelliJ is started and the user's workspace has been setup, this
 * activity sets up the Coursier CLI. Coursier is then used to fetch the model
 * dependencies, and start the language server injecting those
 * dependencies.
 */
public class SmithyPostStartupActivity implements StartupActivity {
    private static final String COURSIER_DIR = "/build/coursier";
    private static final String COURSIER_BIN = COURSIER_DIR + "/cs";
    private static final String COURSIER_CACHE = COURSIER_DIR + "/cache";
    private static final String COURSIER_JAR = "/bin/coursier";
    private static final List<String> DEPENDENCY_LOCATIONS = Arrays.asList(
            "/build/smithy-dependencies.json",
            "/.smithy.json"
    );
    private static final String LANGUAGE_SERVER_ARTIFACT = "software.amazon.smithy:smithy-language-server:0.0.0";

    @Override
    public void runActivity(@NotNull Project project) {
        bootstrapCoursier(project);
        // Cache language server and its dependencies.
        fetchDependencies(project, ListUtils.of("m2Local"), ListUtils.of(LANGUAGE_SERVER_ARTIFACT));
        ModelDependencies dependencies = getDependencies(project);
        // Cache user's model dependencies.
        fetchDependencies(project, dependencies.getRepositories(), dependencies.getArtifacts());
        String[] serverCommand = buildServerCommand(dependencies.getArtifacts(), project);
        SmithyLanguageServerDefinition smithyLanguageServerDefinition = new SmithyLanguageServerDefinition("smithy",
                serverCommand);
        IntellijLanguageClient.addServerDefinition(smithyLanguageServerDefinition);
    }

    // Extracts Coursier cli from plugin jar, copying it to the build directory. See Coursier's JAR-based launcher
    // docs: https://get-coursier.io/docs/cli-installation.html#jar-based-launcher for details on its use as an
    // embedded dependency.
    private void bootstrapCoursier(Project project) {
        File dir = new File(project.getBasePath() + COURSIER_DIR);
        if (!dir.exists()) {
            boolean created = dir.mkdir();
            if (!created) {
                throw new RuntimeException("Could not make directory for Coursier: " + project.getBasePath()
                        + COURSIER_DIR);
            }
        }

        String bin = project.getBasePath() + COURSIER_BIN;
        // If Coursier cli has already been setup and can be executed, return early.
        File existingCoursier = new File(bin);
        if (existingCoursier.exists() && existingCoursier.canExecute()) {
            return;
        }

        // Copy Coursier cli from jar to temporary location, setting it as executable.
        try (
                InputStream inputStream = getClass().getResource(COURSIER_JAR).openStream();
                OutputStream outputStream = new FileOutputStream(bin);
        ) {
            byte[] b = new byte[2048];
            int length;

            while ((length = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, length);
            }
            inputStream.close();
            outputStream.close();
            File coursier = new File(bin);
            coursier.setExecutable(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Get model dependencies defined within user's project.
    private ModelDependencies getDependencies(Project project) {
        String content = getDependenciesContent(project.getBasePath());
        Node node = Node.parseJsonWithComments(content);
        NodeMapper mapper = new NodeMapper();
        return mapper.deserialize(node, ModelDependencies.class);
    }

    // Get dependencies specified by user as JSON string.
    private String getDependenciesContent(String baseDir) {
        for (String location : DEPENDENCY_LOCATIONS) {
            File dependencies = new File(baseDir + location);
            if (dependencies.exists()) {
                return IoUtils.readUtf8File(baseDir + location);
            }
        }
        return "";
    }

    // Build server command, using Coursier to launch language server along with any dependencies add by the user.
    private String[] buildServerCommand(List<String> dependencies, Project project) {
        // Add the language server artifact.
        List<String> artifacts = ListUtils.of(LANGUAGE_SERVER_ARTIFACT);
        // Add model dependency artifacts.
        artifacts.addAll(dependencies);
        List<String> commandParts = getBaseCommand(project,
                "launch",
                // Add maven local repository, where the language server must be cached.
                ListUtils.of("m2Local"),
                // Artifacts for launch command to target, with language server as the first artifact.
                artifacts);

        // Add language server arguments, setting the port to 0 to use stdio for communication.
        commandParts.add("--");
        commandParts.add("0");
        return commandParts.toArray(new String[0]);
    }

    // Fetches dependencies for a list of artifacts from their repositories.
    private void fetchDependencies(Project project, List<String> repositories, List<String> artifacts) {
        List<String> commandParts = getBaseCommand(project, "fetch", repositories, artifacts);
        runCommand(commandParts);
    }

    // Gets base Coursier command.
    private List<String> getBaseCommand(Project project,
                                        String command,
                                        List<String> repositories,
                                        List<String> artifacts
    ) {
        List<String> commandParts = new ArrayList<>(ListUtils.of(
                // Point to the right Coursier binary location.
                project.getBasePath() + COURSIER_BIN,
                // Set the type of command to run.
                command,
                // Set the cache directory.
                "--cache", project.getBasePath() + COURSIER_CACHE));
        // Add each repository to the command, using the `-r` flag.
        for (String repo : repositories) {
            commandParts.add("-r");
            commandParts.add(repo);
        }
        // Add the list of artifacts.
        commandParts.addAll(artifacts);
        return commandParts;
    }

    // Run Coursier cli command.
    private static void runCommand(List<String> command) {
        ProcessBuilder builder = new ProcessBuilder(command);
        try {
            Process proc = builder.start();
            proc.waitFor();
            proc.destroy();
            // Throw a runtime error if the Coursier command failed.
            if (proc.exitValue() != 0) {
                throw new RuntimeException("Coursier command returned non-zero");

            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
