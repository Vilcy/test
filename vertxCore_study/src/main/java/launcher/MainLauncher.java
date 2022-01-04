package launcher;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;

import java.util.function.Consumer;

/**
 * @Author: zhangWs
 * @Date: 2021/12/29 21:01
 * @Classname: Launcher.MainLauncher
 * @Description: TODO
 */
public class MainLauncher {
    public static void main(final String[] args) {
        // 哪种模式？
        final boolean isClustered = false;
        final Launcher launcher = isClustered ? new ClusterLauncher() :
                new SingleLauncher();
        // 设置Options
        /*launcher.start(vertx -> {
            // 执行Vertx相关后续逻辑
            vertx.deployVerticle("verticle.MyVerticle",
                    new DeploymentOptions().setInstances(5));
        });*/

        launcher.start(vertx -> {
            vertx.deployVerticle("json.JavaMapJson");
        });

    }
}
