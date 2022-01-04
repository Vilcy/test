package launcher;

import io.vertx.core.Vertx;
import io.vertx.core.impl.VertxBuilder;

/**
 * @Author: zhangWs
 * @Date: 2021/12/29 18:10
 * @Classname: Launcher.Launcher.VertxLanucher
 * @Description: TODO
 */
public class VertxLanucher {
    public static void main(String[] args) {
        VertxBuilder vertxBuilder = new VertxBuilder();
        Vertx vertx = vertxBuilder.vertx();
    }
}
