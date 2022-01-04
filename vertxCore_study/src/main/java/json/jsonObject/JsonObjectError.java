package json.jsonObject;

import io.vertx.core.json.DecodeException;
import io.vertx.core.json.JsonObject;

/**
 * @Author: zhangWs
 * @Date: 2021/12/31 10:10
 * @Classname: JsonObjectError
 * @Description: TODO
 */
public class JsonObjectError {
    public static void main(String[] args) {

        //键不是用引号
        String script = "{name:\"Lang\"}";
        out(script);

        // 键使用单引号
        final String singleScript = "{'name':\"Lang\"}";
        out(singleScript);

        // 值使用单引号
        final String singleValue = "{\"name\":'name'}";
        out(singleValue);

        // 值无引号
        final String emptyValue = "{\"name\":name}";
        out(emptyValue);

        // 布尔大小写敏感
        final String boolValue = "{\"name\":TRUE}";
        out(boolValue);

        // null字面量异常
        final String nullValue = "{\"name\":Null}";
        out(nullValue);

        // 数值 Java 格式
        final String numberValue = "{\"name\":13L}";
        out(numberValue);


    }



    private static void out(final String literal) {
        try {
            final JsonObject data = new JsonObject(literal);
            System.out.println(data.encodePrettily());
        } catch (final DecodeException ex) {
            System.out.println("解析异常：" + literal);
        }
    }
}
