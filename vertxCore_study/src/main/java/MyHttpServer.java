import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;

/**
 * @Author: zhangWs
 * @Date: 2021/12/28 16:58
 * @Classname: MyHttpServer
 * @Description: TODO
 */
public class MyHttpServer extends AbstractVerticle {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        //部署服务
        vertx.deployVerticle(new MyHttpServer());
    }

    @Override
    public void start() {
        vertx.createHttpServer().requestHandler(request->{
            //获取到response对象
            HttpServerResponse response = request.response();

            //设置响应头
            response.putHeader("Content-type","text/html;charset=utf-8");

            //响应数据
            response.end("success");
        }).listen(80,http->{
            if (http.succeeded()){
                System.out.println("端口可用");
            }else {
                System.out.println("端口不可用");
            }
        });
    }
}
