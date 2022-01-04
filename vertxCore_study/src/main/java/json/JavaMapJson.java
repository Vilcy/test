package json;

import io.vertx.core.json.JsonObject;

/**
 * @Author: zhangWs
 * @Date: 2021/12/31 17:23
 * @Classname: JavaMapJson
 * @Description: TODO
 */
public class JavaMapJson{

    public static void main(final String[] args) {
        JsonObject json = new JsonObject()
                .put("username", "Lang")
                .put("password", "test");

        // Json转User
        User user = json.mapTo(User.class);
        System.out.println(user);
    }
}