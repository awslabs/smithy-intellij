package software.amazon.smithy.plugin.language.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import software.amazon.smithy.plugin.language.SmithyLanguage;

public class SmithyTokenType extends IElementType {
    public SmithyTokenType(@NotNull @NonNls String debugName) {
        super(debugName, SmithyLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "SmithyTokenType." + super.toString();
    }
}
