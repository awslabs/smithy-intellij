package software.amazon.smithy.plugin;

import org.wso2.lsp4intellij.client.languageserver.serverdefinition.RawCommandServerDefinition;

public class SmithyLanguageServerDefinition extends RawCommandServerDefinition {
    public SmithyLanguageServerDefinition(String ext, String[] cmds) {
        super(ext, cmds);
    }
}
