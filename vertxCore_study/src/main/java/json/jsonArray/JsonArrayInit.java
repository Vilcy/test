package json.jsonArray;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonArray;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: zhangWs
 * @Date: 2021/12/31 15:09
 * @Classname: JsonArrayInit
 * @Description: TODO
 */
public class JsonArrayInit {

    public static void main(String[] args) {

        //空json数组
        JsonArray jsonArray = new JsonArray();
        System.out.println(jsonArray.encodePrettily());

        //字面量初始化
        String jsonString = "[1,true,\"Lang\",{\"name\":\"Lang\"}]";
        JsonArray jsonArray1 = new JsonArray(jsonString);
        System.out.println(jsonArray1.encodePrettily());

        //使用list初始化
        List<Object> list = new ArrayList<>() {
            {
                this.add(Boolean.FALSE);
                this.add(Integer.MAX_VALUE);
                this.add("hello");
            }
        };
        JsonArray jsonArray2 = new JsonArray(list);
        System.out.println(jsonArray2.encodePrettily());

        //使用buffer初始化
        Buffer buffer = Buffer.buffer(jsonString);
        JsonArray jsonArray3 = new JsonArray(buffer);
        System.out.println(jsonArray3.encodePrettily());
    }
}
