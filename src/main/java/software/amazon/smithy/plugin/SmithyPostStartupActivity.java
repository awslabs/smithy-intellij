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
import org.jetbrains.annotations.NotNull;
import org.wso2.lsp4intellij.IntellijLanguageClient;

public class SmithyPostStartupActivity implements StartupActivity {

    @Override
    public void runActivity(@NotNull Project project) {
        String lspPath = System.getProperty("user.home") + "/.m2/repository/software/amazon/smithy/"
                + "smithy-language-server/0.0.0/smithy-language-server-0.0.0-all.jar";
        String[] command = new String[]{"java", "-jar", lspPath, "0"};
        SmithyLanguageServerDefinition smithyLanguageServerDefinition = new SmithyLanguageServerDefinition("smithy",
                command);
        IntellijLanguageClient.addServerDefinition(smithyLanguageServerDefinition);
    }
}
