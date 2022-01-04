package util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @Author: zhangWs
 * @Date: 2021/12/31 11:32
 * @Classname: JsonUtil
 * @Description: TODO
 */
public class JsonFileUtil {

    public static String getJsonFileData(String filename) throws IOException {

        String address="C:\\code\\test\\vertxCore_study\\src\\main\\java\\file\\"+filename;

        File file = new File(address);

        return FileUtils.readFileToString(file,"Utf-8");
    }
}
