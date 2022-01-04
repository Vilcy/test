package launcher;

import io.vertx.core.Vertx;

import java.util.function.Consumer;

/**
 * @Author: zhangWs
 * @Date: 2021/12/29 20:55
 * @Classname: Launcher.Launcher
 * @Description: TODO
 */
public interface Launcher {

    void start(Consumer<Vertx> startConsumer);
}
