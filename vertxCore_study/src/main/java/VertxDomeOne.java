import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.FileProps;
import io.vertx.core.file.FileSystem;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.client.HttpRequest;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @Author: zhangWs
 * @Date: 2021/12/27 9:52
 * @Classname: VertxDomeOne
 * @Description: TODO
 */
public class VertxDomeOne extends AbstractVerticle {

    public static void testPeriodic(Vertx vertx,AtomicInteger a){
        vertx.setPeriodic(1000,id-> {
            a.incrementAndGet();
            System.out.println("timer fired"+ a);
        });
    }


    public static void testFuture(Vertx vertx){
        FileSystem fileSystem = vertx.fileSystem();
        Future<FileProps> future = fileSystem.props("C:\\code\\test\\vertxCore_study\\src\\main\\java\\my_file.txt");

        future.onComplete((AsyncResult<FileProps> ar)->{
           if (ar.succeeded()){
               FileProps result = ar.result();
               System.out.println("File size" + result.size());
               System.out.println(result);
           }else {
               System.out.println("Failure：" +ar.cause().getCause());
           }
        });
    }


    public static void testWebClient(Vertx vertx){
        System.out.println("1");

        WebClient
                .create(vertx)
                // 这里指定的是请求的地址
                .postAbs("http://localhost:8080/mng/project/getProjectNumber/v1")
                // buffer是请求的数据
                .send( res -> {
                    if (res.succeeded()) {
                        // 请求远程服务成功
                        System.out.println("2");
                        HttpResponse<Buffer> result = res.result();
                        System.out.println("result = " + result);

                    } else {
                        // 请求失败
                        String message = res.cause().getMessage();
                        System.out.println("message = " + message);
                    }
                });

        System.out.println("3");
    }

    /**
     * @Author: Zhang.ws
     * @Date: 2021/12/29 11:20
     * @Description: 测试异步
     */
    public static void testAsynchronous(Vertx vertx){
        System.out.println("1");

        vertx.setPeriodic(1000,result->System.out.println("2"));

        System.out.println("3");
    }



    public static void main(String[] args) {
        AtomicInteger a= new AtomicInteger();
        Vertx vertx = Vertx.vertx();
        testAsynchronous(vertx);

    }
}
