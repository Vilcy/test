package json.jsonArray;

import io.vertx.core.json.JsonArray;

/**
 * @Author: zhangWs
 * @Date: 2021/12/31 15:43
 * @Classname: JsonArrayGet
 * @Description: TODO
 */
public class JsonArrayGet {

    public static void main(String[] args) {

        // 数组基本
        final JsonArray array = new JsonArray();
        array.add(Boolean.TRUE);
        array.add(12.1f);
        array.add("Whether");

        // 正确读取
        final int length = array.size();
        for (int idx = 0; idx < length; idx++) {
            final Object item = array.getValue(idx);
            if (item instanceof Boolean) {
                System.out.println("布尔值：" + item);
            } else if (item instanceof Float) {
                System.out.println("浮点数：" + item);
            } else if (item instanceof String) {
                System.out.println("字符串：" + item);
            }
        }
        // 错误遍历
        for (int idx = 0; idx < length; idx++) {
            final Float item = array.getFloat(idx);
        }

    }
}
