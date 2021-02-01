package software.amazon.smithy.plugin;

import com.intellij.openapi.application.PreloadingActivity;
import com.intellij.openapi.progress.ProgressIndicator;
import org.jetbrains.annotations.NotNull;
import org.wso2.lsp4intellij.IntellijLanguageClient;

public class SmithyPreloadingActivity extends PreloadingActivity {
    @Override
    public void preload(@NotNull ProgressIndicator indicator) {
        String lspPath = System.getProperty("user.home") + "/.m2/repository/software/amazon/smithy/"
                + "smithy-language-server/0.0.0/smithy-language-server-0.0.0-all.jar";
        String[] command = new String[]{"java", "-jar", lspPath};
        SmithyLanguageServerDefinition smithyLanguageServerDefinition = new SmithyLanguageServerDefinition("smithy",
                command);
        IntellijLanguageClient.addServerDefinition(smithyLanguageServerDefinition);
    }
}
