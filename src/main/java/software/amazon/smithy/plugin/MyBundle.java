package software.amazon.smithy.plugin;

import com.intellij.AbstractBundle;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

public class MyBundle extends AbstractBundle {
    public static final MyBundle INSTANCE = new MyBundle();
    @NonNls public static final String BUNDLE = "message.MyBundle";

    private MyBundle() { super(BUNDLE); }

    @NotNull
    public static String message(@PropertyKey(resourceBundle = BUNDLE) String key, Object... params) {
        return INSTANCE.getMessage(key, params);
    }
}
