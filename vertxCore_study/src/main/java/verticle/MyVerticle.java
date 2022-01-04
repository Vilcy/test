package verticle;

import io.vertx.core.AbstractVerticle;

/**
 * @Author: zhangWs
 * @Date: 2021/12/30 10:33
 * @Classname: Verticle.MyVerticle
 * @Description: TODO
 */
public class MyVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {

        System.out.println(Thread.currentThread().getName()+
                ":hello Verticle:"
                +Thread.currentThread().getId());
    }
}
