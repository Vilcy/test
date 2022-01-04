package verticle;

import io.vertx.core.AbstractVerticle;

/**
 * @Author: zhangWs
 * @Date: 2021/12/30 15:51
 * @Classname: Verticle.LifeVerticle
 * @Description: TODO
 */
public class LifeVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {

        System.out.println(Thread.currentThread().getName()+
                ":Start :"+
                Thread.currentThread().getId()+
                ", Did:" + this.deploymentID());
    }

    @Override
    public void stop() throws Exception {
        System.out.println(Thread.currentThread().getName()+
                ":stop :"+
                Thread.currentThread().getId()+
                ", Did:" + this.deploymentID());
    }
}
