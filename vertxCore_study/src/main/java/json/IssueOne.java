package json;

import io.vertx.core.json.JsonObject;

/**
 * @Author: zhangWs
 * @Date: 2021/12/31 16:43
 * @Classname: IssueOne
 * @Description: TODO
 */
public class IssueOne {
    public static void main(String[] args) {
        JsonObject entries = new JsonObject().put("name","Test");
        entries.put("data",entries.copy());

        System.out.println(entries.encodePrettily());
    }
}
