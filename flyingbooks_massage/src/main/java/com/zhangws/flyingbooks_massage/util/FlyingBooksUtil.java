package com.zhangws.flyingbooks_massage.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: zhangWs
 * @Date: 2022/1/4 9:07
 * @Classname: FlyingBooksUtil
 * @Description: TODO
 */
public class FlyingBooksUtil {


    public static void main(String[] args) {
        String secret = "GWBV9AvFZpYCh8J0jwkBPe";
        String token = "47fc8330-6f68-4261-b762-8fdf82959468";
        String baseUrl= "https://open.feishu.cn/open-apis/bot/v2/hook/"+token;

        String result = send("adadadad", baseUrl,secret);
        System.out.println(result);
    }


    public static String send(String massage,String baseUrl,String secret){
        String result = "";

        try{
            String url = genSign(baseUrl, secret);
            JSONObject body = new JSONObject();
            body.put("msg_type","text");

            body.put("content",massage);

            result = HttpUtil.sendJsonPost(url,body.toJSONString());


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
     * @return 获取拼接了timestamp和sign的url
     */

    private static String genSign(String baseUrl,String secret) {
        String url = "";

        try{
            long timestamp = System.currentTimeMillis();
            //把timestamp+"\n"+密钥当做签名字符串
            String stringToSign = timestamp + "\n" + secret;

            //使用HmacSHA256算法计算签名
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(stringToSign.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            byte[] signData = mac.doFinal(new byte[]{});
            url = baseUrl+"&timestamp=" + timestamp + "&sign=" +
                    URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");


        }catch (Exception e){
            e.printStackTrace();
        }
        return url;
    }
}
