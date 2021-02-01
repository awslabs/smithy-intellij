package software.amazon.smithy.plugin.services;

import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import software.amazon.smithy.plugin.MyBundle;

public final class MyProjectService {
    public MyProjectService(@NotNull Project project) {
        super();
        System.out.println(MyBundle.message("Project service: " + project.getName()));
    }
}
