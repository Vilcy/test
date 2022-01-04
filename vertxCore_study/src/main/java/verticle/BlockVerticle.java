package verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

/**
 * @Author: zhangWs
 * @Date: 2021/12/29 17:29
 * @Classname: Verticle.BlockVerticle
 * @Description: TODO
 */
public class BlockVerticle extends AbstractVerticle {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new BlockVerticle());
    }


    @Override
    public void start() throws Exception {
        try {
            //休眠4s
            Thread.sleep(4000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
