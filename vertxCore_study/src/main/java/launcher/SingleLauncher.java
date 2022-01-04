package launcher;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

import java.util.function.Consumer;

/**
 * @Author: zhangWs
 * @Date: 2021/12/29 20:57
 * @Classname: Launcher.Launcher.SingleLauncher
 * @Description: TODO
 */
public class SingleLauncher implements Launcher {
    @Override
    public void start(Consumer<Vertx> startConsumer) {
        VertxOptions vertxOptions = new VertxOptions();
        Vertx vertx = Vertx.vertx(vertxOptions);
        if (vertx !=null){
            startConsumer.accept(vertx);
        }
    }
}
