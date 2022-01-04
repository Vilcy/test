package json.jsonObject;

import io.vertx.core.json.JsonObject;
import util.JsonFileUtil;

import java.io.IOException;

/**
 * @Author: zhangWs
 * @Date: 2021/12/31 11:54
 * @Classname: JsonObjectCopyMerge
 * @Description: TODO
 */
public class JsonObjectCopyMerge {


    public static void copyMergeJsonObject(){
        //左值
        String jsonLeftFileData = null;
        //右值
        String jsonRightFileData=null;
        try {
            jsonLeftFileData = JsonFileUtil.getJsonFileData("copy/left.json");
            JsonObject leftJson = new JsonObject(jsonLeftFileData);
            //右值
            jsonRightFileData = JsonFileUtil.getJsonFileData("copy/right.json");
            JsonObject rightJson = new JsonObject(jsonRightFileData);

            JsonObject result = leftJson.copy().mergeIn(rightJson);
            /* 分别修改左右值 */
            result.put("actor1", "Lang");
            result.put("actor3", 121);
            System.out.println("leftJson = " + leftJson);
            System.out.println("rightJson = " + rightJson);
            System.out.println("result = " + result);

        } catch (IOException e) {
            e.printStackTrace();
        }




    }


    public static void main(String[] args) {


        copyMergeJsonObject();

        try {
            //左值
            String jsonLeftFileData = JsonFileUtil.getJsonFileData("copy/left.json");
            JsonObject leftJson = new JsonObject(jsonLeftFileData);

            //右值
            String jsonRightFileData = JsonFileUtil.getJsonFileData("copy/right.json");
            JsonObject rightJson = new JsonObject(jsonRightFileData);

            //直接合并
            JsonObject result = leftJson.mergeIn(rightJson);

            System.out.println("leftJson = " + leftJson);
            System.out.println("rightJson = " + rightJson);
            System.out.println("result = " + result);

            System.out.println("-------- 分割线 --------");
            /* 分别修改左右值 */
            result.put("actor1", "Lang");
            result.put("actor3", 121);
            System.out.println("leftJson = " + leftJson);
            System.out.println("rightJson = " + rightJson);
            System.out.println("result = " + result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
