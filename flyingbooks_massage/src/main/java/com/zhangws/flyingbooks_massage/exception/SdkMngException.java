package com.zhangws.flyingbooks_massage.exception;

/**
 * @ClassName: ShanliaoServerException
 * @Description: TODO
 * @Author: wei.zhang
 * @Date: 2021/5/7 9:13
 */
public class SdkMngException extends RuntimeException {

    private String code;

    private String msg;


    public SdkMngException(String msg, Throwable cause) {
        super(msg, cause);
        this.code = "-1";
        this.msg = msg;
    }

    public SdkMngException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return this.msg;
    }

}
