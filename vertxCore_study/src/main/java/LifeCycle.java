import launcher.SingleLauncher;
import verticle.LifeVerticle;
import io.vertx.core.DeploymentOptions;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Author: zhangWs
 * @Date: 2021/12/30 15:55
 * @Classname: LifeCycle
 * @Description: TODO
 */
public class LifeCycle {

    private static final ConcurrentMap<String, String> IDS = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        SingleLauncher singleLauncher = new SingleLauncher();

        singleLauncher.start(vertx->{
            //发布
            vertx.deployVerticle(LifeVerticle::new,new DeploymentOptions().setInstances(10),res->{
                if (res.succeeded()){
                    IDS.put(res.result(), res.result());
                }
            });

            vertx.deployVerticle(LifeVerticle::new,new DeploymentOptions().setInstances(3), res->{
                if(res.succeeded()){
                    IDS.put(res.result(), res.result());
                }
            });

            Runtime.getRuntime().addShutdownHook(new Thread(()->{
                //撤销
                IDS.keySet().forEach(itm->vertx.undeploy(itm,res-> System.out.println("Successfully undeploy the item:"+itm)));
            }));

        });


    }
}
