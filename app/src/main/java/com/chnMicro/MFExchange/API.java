package com.chnMicro.MFExchange;

/**
 * Created by Enel on 2015/2/9.
 *
 * 数据接口
 */
public enum API {
    /**
     * 登录
     */
    LOGIN("/loginUser.do");


    private String url;

    private API(String api) {
        this.url = api;
    }

    public String url() {
        return url;
    }
}
