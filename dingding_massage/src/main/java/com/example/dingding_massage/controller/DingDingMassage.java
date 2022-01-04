package com.example.dingding_massage.controller;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author EDY
 */
@RestController
@RequestMapping("/massage")
public class DingDingMassage {

    @PostMapping("/test")
    public String test(@RequestParam("url") String url,@RequestParam("massage") String massage,@RequestParam("secret")String secret) throws ApiException {

        String uRL = "";
        try {
            long timestamp = System.currentTimeMillis();
            String stringToSign = timestamp + "\n" + secret;
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            byte[] signData = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
            uRL = url + "&timestamp=" + timestamp + "&sign=" +
                    URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }

        DefaultDingTalkClient dingTalkClient = new DefaultDingTalkClient(uRL);
        OapiRobotSendRequest sendRequest = new OapiRobotSendRequest();

        //设置信息类型
        sendRequest.setMsgtype("text");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent("测试文本信息"+massage);
        sendRequest.setText(text);


        OapiRobotSendRequest.At at= new OapiRobotSendRequest.At();
        //要发送信息的手机号：单个的情况使用：Collections.singletonList；多个的情况使用：Arrays。asList
        //at.setAtMobiles(Collections.singletonList("12312313123"));
        //isAtAll类型如果不为Boolean，升级最新的sdk
        at.setIsAtAll(true);
        //at.setAtUserIds(Arrays.asList("102312","13131"));
        sendRequest.setAt(at);

        //发送链接式信息
        sendRequest.setMsgtype("link");
        OapiRobotSendRequest.Link link = new OapiRobotSendRequest.Link();
        link.setMessageUrl("https://www.dingtalk.com/");
        link.setPicUrl("");
        link.setTitle("时代的火车向前开");
        link.setText("这个即将发布的新版本，创始人xx称它为红树林。而在此之前，每当面临重大升级，产品经理们都会取一个应景的代号，这一次，为什么是红树林");
        sendRequest.setLink(link);

        //发送markdown格式信息
        sendRequest.setMsgtype("markdown");
        OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
        markdown.setTitle("上海天气");
        markdown.setText("#### 杭州天气 @156xxxx8827\\n\" +\n" +
                "        \"> 9度，西北风1级，空气良89，相对温度73%\\n\\n\" +\n" +
                "        \"> ![screenshot](https://gw.alicdn.com/tfs/TB1ut3xxbsrBKNjSZFpXXcXhFXa-846-786.png)\\n\"  +\n" +
                "        \"> ###### 10点20分发布 [天气](https://www.thinkpage.cn/) \\n");
        sendRequest.setMarkdown(markdown);

        OapiRobotSendResponse response = dingTalkClient.execute(sendRequest);


        return response.getErrmsg();
    }


    private static String getSign(String baseUrl, String token, String secret) {
        String url = "";
        try {
            long timestamp = System.currentTimeMillis();
            String stringToSign = timestamp + "\n" + secret;
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            byte[] signData = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
            url = baseUrl +"?access_token="+ token + "&timestamp=" + timestamp + "&sign=" +
                    URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
        } catch (Exception e) {
            //log.error("【钉钉】获取签名失败！", e);
            e.printStackTrace();
        }
        return url;
    }
}
