package com.chnMicro.MFExchange.bean;

import com.google.gson.JsonObject;

/**
 * Created by Enel on 2015/2/5.
 *
 * 所有网络响应Json的基类
 */
public class BaseResp {
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_NOT_LOGIN = -1;    //超时或异地登陆，傻傻分不清楚
    public static final int CODE_LOGIN_TIMEOUT = -2;    //超时或异地登陆，傻傻分不清楚

    public int respcode = -10000;
    public String message = "";
    public JsonObject result;

    /**
     * 未登录、登录超时、异地登陆
     */
    public boolean needButNotLogin() {
        return CODE_NOT_LOGIN == respcode || CODE_LOGIN_TIMEOUT == respcode;
    }

    /**
     * 业务操作是否成功
     */
    public boolean success(){
        return CODE_SUCCESS == respcode;
    }

    /**
     * 业务操作是否失败
     */
    public boolean failure() {
        return !needButNotLogin() && !success();
    }

}
