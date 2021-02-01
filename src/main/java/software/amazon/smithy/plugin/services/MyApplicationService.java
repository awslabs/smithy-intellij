package software.amazon.smithy.plugin.services;

import software.amazon.smithy.plugin.MyBundle;

public final class MyApplicationService {
    public MyApplicationService() {
        System.out.println(MyBundle.message("Application Service"));
    }
}
