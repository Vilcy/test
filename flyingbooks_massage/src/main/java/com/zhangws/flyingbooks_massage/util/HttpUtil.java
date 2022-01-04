package com.zhangws.flyingbooks_massage.util;

import com.zhangws.flyingbooks_massage.exception.SdkMngErrorCode;
import com.zhangws.flyingbooks_massage.exception.SdkMngException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: HttpUtil
 * @Description: TODO
 * @Author: wei.zhang
 * @Date: 2021/11/30 9:52
 */
public class HttpUtil {
    final private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private final static int defaultReadTimeoutMS = 5000;

    private final static int defaultConnectTimeoutMS = 5000;


    public static String sendGet(String url, String params, Map<String, String> headParams) throws SdkMngException {
        String result = "";
        BufferedReader in = null;
        try {
            String urlName = "";
            if (params == null || params.trim().isEmpty()) {
                urlName = url;
            } else {
                urlName = url + "?" + params;
            }

            URL realUrl = new URL(urlName);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");

            for (Map.Entry<String, String> entry : headParams.entrySet()) {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }

            conn.setConnectTimeout(defaultConnectTimeoutMS);
            conn.setReadTimeout(defaultReadTimeoutMS);
            conn.connect();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += "\n" + line;
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("请求接口:{}异常", url);
            throw new SdkMngException(SdkMngErrorCode.SERVER_ERROR, "请求URL异常");
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                logger.error("请求接口:{}异常", url);
                throw new SdkMngException(SdkMngErrorCode.SERVER_ERROR, "请求URL异常");
            }
        }
        return result;
    }

    public static String sendGet(String url, String params) throws SdkMngException {
        Map<String, String> headParam = new LinkedHashMap<String, String>();
        return sendGet(url, params, headParam);
    }

    public static String sendPost(String url, String params) throws SdkMngException {
        Map<String, String> headParam = new LinkedHashMap<String, String>();
        return sendPost(url, params, headParam);
    }

    public static String sendPost(String url, String params, Map<String, String> headParams) throws SdkMngException {
        return sendPost(url, params, -1, headParams);
    }

    public static String sendJsonPost(String url, String msg) throws SdkMngException {

        try {
            URL conn_url = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) conn_url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setRequestProperty("Charset", "UTF-8");

            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            connection.setConnectTimeout(defaultConnectTimeoutMS);
            connection.setReadTimeout(defaultReadTimeoutMS);
            connection.connect();

            // POST请求
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.write(msg.getBytes("UTF-8"));
            out.flush();
            out.close();

            // 读取响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }
            reader.close();
            // 断开连接
            connection.disconnect();
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("请求接口:{}异常", url);
            throw new SdkMngException(SdkMngErrorCode.SERVER_ERROR, "请求URL异常");
        }
    }

    public static String sendPost(String url, String params, int timeout, Map<String, String> headParams) throws SdkMngException {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();

            if (timeout >= 0) {
                conn.setConnectTimeout(timeout);
            } else {
                conn.setConnectTimeout(defaultConnectTimeoutMS);
                conn.setReadTimeout(defaultReadTimeoutMS);
            }
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");

            for (Map.Entry<String, String> entry : headParams.entrySet()) {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }

            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "utf-8"));
            out.print(params);
            // System.out.println(params);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            logger.error("请求接口:{}异常", url);
            throw new SdkMngException(SdkMngErrorCode.SERVER_ERROR, "请求URL异常");
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                logger.error("请求接口:{}异常", url);
                throw new SdkMngException(SdkMngErrorCode.SERVER_ERROR, "请求URL异常");
            }
        }
        logger.info("请求url:{},参数{},返回数据:{}",url,params,result);
        return result;
    }


    public static void main(String[] args) throws SdkMngException {
        String url4 = "http://172.16.42.185:8081/prod/create";
        Map<String, String> headMap = new HashMap<String, String>();
        String params="{\"oldUrl\":\"172.16.42.185:8081/v-ElSP2\",\"phone\":\"17521518519\",\"account\":\"19521299827\",\"batch\":\"10002\",\"inviterPhone\":\"17521518519\"}";
        String params1="oldUrl=172.16.42.185:8081/v-ElSP2&phone=17521518519&account=19521299827&batch=10002&inviterPhone=17521518519";
        String res = HttpUtil.sendPost(url4, params1, headMap);
        System.out.println(res);
    }

}