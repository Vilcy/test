package json.jsonArray;

import io.vertx.core.json.JsonArray;

/**
 * @Author: zhangWs
 * @Date: 2021/12/31 16:03
 * @Classname: JsonArrayAdd
 * @Description: TODO
 */
public class JsonArrayAdd {

    public static void main(String[] args) {
        //原始数组
        JsonArray jsonArray = new JsonArray();
        jsonArray.add("A").add("B").add("C");

        //add
        JsonArray addedArray = new JsonArray();
        addedArray.add("D").add("E");

        JsonArray add = jsonArray.copy().add(addedArray);
        System.out.println(add.encodePrettily());

        System.out.println("-------分割-------");

        //addAll
        JsonArray addAllArray = new JsonArray();
        addAllArray.add("D").add("E");

        JsonArray addAll = jsonArray.copy().addAll(addAllArray);
        System.out.println(addAll.encodePrettily());
    }
}
