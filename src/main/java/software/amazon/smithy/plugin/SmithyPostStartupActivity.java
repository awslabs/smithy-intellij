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

public class SmithyPostStartupActivity implements StartupActivity {
    private static final String CS_DIR = "/build/coursier";
    private static final String CS_BIN = CS_DIR + "/cs";
    private static final String CS_CACHE = CS_DIR + "/cache";
    private static final String CS_JAR = "/bin/coursier";
    private static final List<String> DEPENDENCY_LOCATIONS = Arrays.asList(
            "/build/smithy-dependencies.json",
            "/.smithy.json"
    );
    private static final String LANGUAGE_SERVER_ARTIFACT = "software.amazon.smithy:smithy-language-server:0.0.0";

    @Override
    public void runActivity(@NotNull Project project) {
        bootstrapCoursier(project);
        cacheLanguageServer(project);
        ModelDependencies dependencies = getDependencies(project);
        cacheDependencies(dependencies, project);
        String[] serverCommand = buildServerCommand(dependencies.getArtifacts(), project);
        SmithyLanguageServerDefinition smithyLanguageServerDefinition = new SmithyLanguageServerDefinition("smithy",
                serverCommand);
        IntellijLanguageClient.addServerDefinition(smithyLanguageServerDefinition);
    }

    // Extracts coursier cli from plugin jar, copying it to build directory.
    private void bootstrapCoursier(Project project) {
        File dir = new File(project.getBasePath() + CS_DIR);
        if (!dir.exists()) {
            boolean created = dir.mkdir();
            if (!created) {
                throw new RuntimeException("Could not make directory for coursier: " + project.getBasePath() + CS_DIR);
            }
        }

        String bin = project.getBasePath() + CS_BIN;
        // If coursier cli has already been setup and can be executed, return early.
        File existingCoursier = new File(bin);
        if (existingCoursier.exists() && existingCoursier.canExecute()) {
            return;
        }

        // Copy coursier cli from jar to temporary location, setting it as executable.
        try {
            InputStream inputStream = getClass().getResource(CS_JAR).openStream();
            OutputStream outputStream = new FileOutputStream(bin);
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

    // Use coursier to cache user's model dependencies.
    private void cacheDependencies(ModelDependencies dependencies, Project project) {
        List<String> commandParts = new ArrayList<>(Arrays.asList(project.getBasePath() + CS_BIN,
                "fetch", "--cache", project.getBasePath() + CS_CACHE));
        for (String repository : dependencies.getRepositories()) {
            commandParts.add("-r");
            commandParts.add(repository);
        }
        commandParts.addAll(dependencies.getArtifacts());
        runCommand(commandParts);
    }

    // Use coursier to cache language server and its dependencies.
    private void cacheLanguageServer(Project project) {
        List<String> commandParts = new ArrayList<>(Arrays.asList(project.getBasePath() + CS_BIN, "fetch",
                "--cache", project.getBasePath() + CS_CACHE, "-r", "m2Local", LANGUAGE_SERVER_ARTIFACT));
        runCommand(commandParts);
    }

    // Build server command, using coursier to launch language server along with any dependencies add by the user.
    private String[] buildServerCommand(List<String> dependencies, Project project) {
        List<String> commandParts = new ArrayList<>(Arrays.asList(project.getBasePath() + CS_BIN,
                "launch", "--cache", project.getBasePath() + CS_CACHE, LANGUAGE_SERVER_ARTIFACT));
        // Add model dependency artifacts.
        commandParts.addAll(dependencies);
        // Add maven local repository, where LSP must be cached.
        commandParts.add("-r");
        commandParts.add("m2Local");
        // Add LSP arguments
        commandParts.add("--");
        commandParts.add("0");
        return commandParts.toArray(new String[0]);
    }

    // Run a coursier cli command.
    private static void runCommand(List<String> command) {
        ProcessBuilder builder = new ProcessBuilder(command);
        try {
            Process proc = builder.start();
            proc.waitFor();
            proc.destroy();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
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
}
