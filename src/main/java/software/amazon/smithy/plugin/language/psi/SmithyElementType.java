package software.amazon.smithy.plugin.language.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import software.amazon.smithy.plugin.language.SmithyLanguage;

public class SmithyElementType extends IElementType {
    public SmithyElementType(@NotNull @NonNls String debugName) {
        super(debugName, SmithyLanguage.INSTANCE);
    }
}
