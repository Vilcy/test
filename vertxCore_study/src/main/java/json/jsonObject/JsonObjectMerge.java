package json.jsonObject;

import io.vertx.core.json.JsonObject;
import org.apache.commons.io.FileUtils;
import util.JsonFileUtil;

import java.io.File;
import java.io.IOException;

/**
 * @Author: zhangWs
 * @Date: 2021/12/31 11:29
 * @Classname: JsonObjectMerge
 * @Description: TODO
 */
public class JsonObjectMerge {
    public static void main(String[] args) {

        try {
            //左值
            String jsonLeftData = JsonFileUtil.getJsonFileData("left.json");
            JsonObject leftJsonObject = new JsonObject(jsonLeftData);

            //右值
            String jsonRightData = JsonFileUtil.getJsonFileData("right.json");
            JsonObject rightJsonObject = new JsonObject(jsonRightData);

            /* 合并，深度为2 */
            JsonObject jsonObject = leftJsonObject.mergeIn(rightJsonObject,2);
            System.out.println(jsonObject.encodePrettily());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
