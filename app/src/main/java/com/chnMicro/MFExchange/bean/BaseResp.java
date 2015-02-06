package com.chnMicro.MFExchange.bean;

/**
 * Created by Enel on 2015/2/5.
 */
public class BaseResp {
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_NOT_LOGIN = -1;    //超时或异地登陆，傻傻分不清楚
    public static final int CODE_LOGIN_TIMEOUT = -2;    //超时或异地登陆，傻傻分不清楚

    public int respCode = -10000;
    public String message = "";

    /**
     * 未登录、登录超时、异地登陆
     */
    public boolean needButNotLogin() {
        return CODE_NOT_LOGIN == respCode || CODE_LOGIN_TIMEOUT == respCode;
    }

    /**
     * 业务操作是否成功
     */
    public boolean success(){
        return CODE_SUCCESS == respCode;
    }

    /**
     * 业务操作是否失败
     */
    public boolean failure() {
        return !needButNotLogin() && !success();
    }

}
