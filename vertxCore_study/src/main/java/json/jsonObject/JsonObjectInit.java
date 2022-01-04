package json.jsonObject;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhangWs
 * @Date: 2021/12/31 9:50
 * @Classname: JsonObjectInit
 * @Description: TODO
 */
public class JsonObjectInit {

    public static void main(String[] args) {


        //空json对象
        JsonObject entries1 = new JsonObject();
        System.out.println(entries1.encodePrettily());

        //字面初始化
        String literal = "{\"name\":\"Lang\"}";

        JsonObject entries = new JsonObject(literal);

        System.out.println(entries.encodePrettily());

        //使用Map初始化
        Map<String, Object> map = new HashMap<>();
        map.put("name","张三");
        JsonObject entries2 = new JsonObject(map);
        System.out.println(entries2.encodePrettily());

        //使用buffer初始化，buffer缓冲区
        Buffer buffer = Buffer.buffer(literal);
        JsonObject entries3 = new JsonObject(buffer);
        System.out.println(entries3.encodePrettily());
    }
}
