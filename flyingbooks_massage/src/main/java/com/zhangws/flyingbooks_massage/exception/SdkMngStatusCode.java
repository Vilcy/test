package com.zhangws.flyingbooks_massage.exception;

/**
 * @ClassName: ShanliaoStatusCode
 * @Description: TODO
 * @Author: wei.zhang
 * @Date: 2021/5/7 9:20
 */
public class SdkMngStatusCode {

    /**
     * Desc: 数据返回成功
     */
    public final static String SUCCESS = "0";

    /**
     * Desc: token错误
     */
    public final static String TOKEN_ERROR = "1";



    /**
     * Desc: 参数错误
     */
    public final static String PARAM_ERROR = "2";


    public final static String USER_IS_FRIEND_ALREADY = "3";
    /**
     * 用户不存在
     */
    public final static String USER_IS_NOT_EXIST = "4";
    /**
     * 人像对比未过
     */
    public final static String RENXIANG_SHIBIE_WEIGUO = "5";
    /**
     * preToken解析失败
     */
    public final static String PRETOKEN_ANALYSIS_FAILURE = "6";
    /**
     * 本机号校验失败
     */
    public final static String PHONE_TOKEN_VALIDATE_FAILURE = "7";
    /**
     * 本机号校验异常
     */
    public final static String PHONE_TOKEN_VALIDATE_ERROR = "8";
    /**
     * 一键登录校验失败
     */
    public final static String SHANYAN_VALIDATE_FAILURE = "9";

    /**
     * 该用户不是你的好友
     */
    public final static String USER_IS_NOT_YOUR_FRIEND = "10";


    /**
     * 未知异常
     */
    public final static String TOKEN_DISABLE = "11";
    /**
     * 声网token生成异常
     */
    public final static String SHENGWANG_TOEKN_ANALYSIS_FAILURE = "12";

    /**
     * 闪聊统计参数错误
     */
    public final static String SHENGWANG_STATISTICAL_PARAM_ERROR = "13";

    /**
     * 数据不存在
     */
    public final static String DATA_NOT_EXISTS = "14";
    /**
     * Desc: 数据返回失败
     */
    public final static String FAILURE = "15";
    /**
     * 没有权限
     */
    public final static String NO_POWER = "16";

    /**
     * token超时
     */
    public final static String TOKEN_TIMEOUT = "17";

    /**
     * token更新
     */
    public final static String TOKEN_UPDATE = "18";
    /**
     * 活体带面具hack
     */
    public final static String RENXIANG_HACK_WEIGUO = "19";
    /**
     * 已入群
     */
    public final static String USER_IS_CHANNEL_MENMBER_ALREADY = "20";

    /**
     * Desc: 服务端未知错误
     */
    public final static String SERVER_ERROR = "999";
}
