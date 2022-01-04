package json.jsonObject;

import io.vertx.core.json.JsonObject;

import java.util.Date;

/**
 * @Author: zhangWs
 * @Date: 2021/12/31 10:36
 * @Classname: JsonObjectSet
 * @Description: TODO
 */

enum StringType {
    TEST1, TEST2
}

public class JsonObjectSet {

    public static void main(String[] args) {
        /* 枚举类型 */
        final JsonObject data = new JsonObject();
        data.put("enum", StringType.TEST1);

        /* CharSequence */
        final CharSequence sequence = "Hello World";
        data.put("str1", sequence);
        System.out.println(data.encodePrettily());

        /* Error：Date类型 */
        final Date date = new Date();
        data.put("date", date);
        System.out.println(data.encodePrettily());
    }

}
