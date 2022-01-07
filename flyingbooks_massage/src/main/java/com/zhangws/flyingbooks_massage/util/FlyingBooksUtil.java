package com.zhangws.flyingbooks_massage.util;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.nio.charset.StandardCharsets;


/**
 * @Author: zhangWs
 * @Date: 2022/1/4 9:07
 * @Classname: FlyingBooksUtil
 * @Description: TODO
 */
public class FlyingBooksUtil {

    public static void main(String[] args) {
        String secret = "VQYTIsMeNInuspjrOc1YOh";
        String baseUrl= "https://open.feishu.cn/open-apis/bot/v2/hook/b29ad0d1-9a23-439a-9b2b-df2582337efd";

        String send = send("哈哈哈", baseUrl, secret);
        System.out.println(send);
    }


    public static String send(String massage,String baseUrl,String secret){
        String result = "";
        long timestamp = System.currentTimeMillis();
        String sign = genSign(timestamp,secret);
        System.out.println(sign+"："+timestamp);
        try{
            JSONObject body = new JSONObject();
            body.put("timestamp",timestamp);
            body.put("sign",sign);

            body.put("msg_type","text");

            JSONObject text = new JSONObject();
            text.put("text",massage);

            body.put("content",text);
           result = HttpUtil.createPost(baseUrl).body(JSONUtil.toJsonStr(body)).execute().body();

        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


    /**
     * @Author: Zhang.ws
     * @Date: 2022/1/4 9:18
     * @Description: 获取签名
     * @Param: secret 密钥
     */

    private static String genSign(long timestamp, String secret) {

        try{
            //把timestamp+"\n"+密钥当做签名字符串
            String stringToSign = timestamp + "\n" + secret;

            //使用HmacSHA256算法计算签名
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(stringToSign.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            byte[] signData = mac.doFinal(new byte[]{});

            return new String(Base64.encodeBase64(signData));

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
