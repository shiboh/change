package com.chnMicro.MFExchange;

import org.apache.http.HttpEntity;

/**
 * Created by Enel on 2015/2/6.
 * <p/>
 * 所有request的基类
 */
public class Request {
    private final String BASE_URL = Constants.HOST;
    private String url;
    private HttpEntity entity;

    /**
     * @param api    见API.java
     * @param entity 请求实体
     */
    public Request(API api, HttpEntity entity) {
        this.url = api.url();
        this.entity = entity;
    }

    /**
     * @return 相对地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return 请求实体
     */
    public HttpEntity getEntity() {
        return entity;
    }

    /**
     * @return 绝对地址
     */
    public String getAbsoluteUrl() {
        return BASE_URL + url;
    }

}
