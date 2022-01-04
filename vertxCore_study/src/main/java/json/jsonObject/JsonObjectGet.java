package json.jsonObject;

import io.vertx.core.json.JsonObject;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @Author: zhangWs
 * @Date: 2021/12/31 10:45
 * @Classname: JsonObjectGet
 * @Description: TODO
 */
public class JsonObjectGet {

    public static void getBoolean(){
        JsonObject entries = new JsonObject();
        entries.put("result","true");
        System.out.println(entries.getBoolean("result"));
    }

    /**
     * @Author: Zhang.ws
     * @Date: 2021/12/31 11:10
     * @Description: 将文件中读取内容转换成JsonObject
     */
    public static void getJsonFile() throws IOException {
        /**
         * @Author: Zhang.ws
         * @Date: 2021/12/31 11:11
         * @Description: 引用了：commons-io中的FileUtils
         */
        File file = new File("C:\\code\\test\\vertxCore_study\\src\\main\\java\\file\\input.json");
        String string = FileUtils.readFileToString(file, "UTF-8");
        JsonObject entries = new JsonObject(string);
        System.out.println(entries.getInteger("age"));
    }

    public static void main(String[] args) {
        try {
            getJsonFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
