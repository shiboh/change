package com.chnMicro.MFExchange;

import android.os.Build;

import com.chnMicro.MFExchange.util.AppUtil;
import com.google.gson.JsonObject;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Enel on 2015/2/6.
 * <p/>
 * 构造请求
 */
public class RequestMaker {
    private final static int API_20 = 20, API_21 = 21;

    /**
     * 登录
     */
    public static Request getLoginReq(String username, String password) {
        JsonObject infoJson = new JsonObject();
        infoJson.addProperty("username", username);
        infoJson.addProperty("loginPwd", password);
        HttpEntity entity = getReqEntity(infoJson, 20, true);
        Request request = new Request(API.LOGIN, entity);
        return request;
    }

    /**
     * 构造请求entity
     *
     * @param infoJson   请求中的[info]部分
     * @param apiVersion [auth]中，version字段，接口版本
     * @param encryptPwd [auth]中，base64字段，否密码进行加密
     * @return
     */
    private static HttpEntity getReqEntity(JsonObject infoJson, int apiVersion, boolean encryptPwd) {
        try {
            List<BasicNameValuePair> params = new ArrayList<>();
            BasicNameValuePair info = new BasicNameValuePair("info", infoJson.toString());
            BasicNameValuePair auth = getAuthPair(apiVersion, encryptPwd);
            params.add(info);
            params.add(auth);
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, HTTP.UTF_8);
            return entity;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 构造请求中的auth部分
     *
     * @param apiVerison 请求的接口版本号
     * @param encryptPwd 密码是否经过base64处理。1-base64过，0-没base64处理
     * @return
     */
    public static BasicNameValuePair getAuthPair(int apiVerison, boolean encryptPwd) {
        JsonObject authJson = new JsonObject();
        authJson.addProperty("appver", AppUtil.getAppVersionName());    //app版本名
        authJson.addProperty("osver", Build.VERSION.RELEASE);           //系统版本号
        authJson.addProperty("source", Constants.Auth.SOURCE);          //平台：4-iOS，5-Android
        authJson.addProperty("vendor", Constants.Auth.VENDOR);          //来源
        authJson.addProperty("version", apiVerison);                    //请求的接口版本号
        authJson.addProperty("base64", encryptPwd ? 1 : 0);             //密码是否经过base64处理。1-base64过，0-没base64处理
        BasicNameValuePair auth = new BasicNameValuePair("auth", authJson.toString());
        return auth;
    }
}
