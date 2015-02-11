package com.chnMicro.MFExchange;

import android.content.Context;

import com.chnMicro.MFExchange.bean.BaseResp;
import com.chnMicro.MFExchange.util.LogUtil;
import com.chnMicro.MFExchange.util.Prompter;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BaseJsonHttpResponseHandler;
import com.loopj.android.http.MySSLSocketFactory;
import com.loopj.android.http.ResponseHandlerInterface;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLDecoder;
import java.security.KeyStore;

/**
 * Created by Enel on 2015/2/5.
 * <p/>
 * 网络请求客户端
 */
public class WJSClient {
    private static Context context = MiFieApplication.context;
    private static final String BASE_URL = Constants.HOST;
    private static AsyncHttpClient client = new AsyncHttpClient();

    static {
        client = getMyAsyncHttpClient();
    }

    /**
     * 执行post请求
     *
     * @param context
     * @param url             接口地址
     * @param entity          请求实体
     * @param responseHandler 用来处理response
     */
    public static void post(Context context, String url, HttpEntity entity, ResponseHandlerInterface responseHandler) {
        try {
            String reqContent = EntityUtils.toString(entity, HTTP.UTF_8);
            reqContent = URLDecoder.decode(reqContent, HTTP.UTF_8);
            LogUtil.info(WJSClient.class, "url:" + url + "\n" + reqContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        client.post(context, url, entity, "", responseHandler);
    }

    /**
     * 执行post请求
     *
     * @param context
     * @param request         封装了url和entity的请求对象
     * @param responseHandler 用来处理response
     */
    public static void post(Context context, Request request, ResponseHandlerInterface responseHandler) {
        post(context, request.getAbsoluteUrl(), request.getEntity(), responseHandler);
    }

    /**
     * 创建自定义client，可以http、https
     */
    private static AsyncHttpClient getMyAsyncHttpClient() {
        try {
            AsyncHttpClient client = new AsyncHttpClient();
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null, null);
            MySSLSocketFactory mySSLSocketFactory = new MySSLSocketFactory(trustStore);
            client.setSSLSocketFactory(mySSLSocketFactory);
            return client;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 处理response回来的json信息
     */
    public abstract static class WJSBaseJsonHttpResponseHandler extends BaseJsonHttpResponseHandler<BaseResp> {
        @Override
        public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, BaseResp response) {
            LogUtil.info(WJSClient.class, "请求成功。statusCode:" + statusCode + "。" + rawJsonResponse);

            if (response.needButNotLogin()) {
                LogUtil.info(WJSClient.class, "需要是登录状态，但是没登陆");
                //TODO: 跳转到登录界面
                Prompter.toast(context, "jump to LoginActivity");
                return;
            }

            //业务操作失败，toast失败提示
            if (response.failure()) {
                LogUtil.info(WJSClient.class, "业务操作失败。respCode:" + response.respcode);
                Prompter.toast(context, response.message);
                return;
            }

            /**
             * 处理业务逻辑
             */
            onRealSuccess(response);
        }

        /**
         * 真·业务逻辑
         * onSuccess() 请求成功，但是业务不一定成功
         * onRealSuccess() 业务处理成功
         */
        protected abstract void onRealSuccess(BaseResp response);

        @Override
        public void onFailure(int statusCode, Header[] headers, Throwable throwable, String rawJsonData, BaseResp errorResponse) {
            LogUtil.info(WJSClient.class, "请求失败。statusCode:" + statusCode);
            Prompter.toast(context, R.string.msg_error_network);
        }

        @Override
        protected BaseResp parseResponse(String rawJsonData, boolean isFailure) throws Throwable {
            if (!isFailure) {
                Gson gson = MiFieApplication.gson;
                BaseResp baseResp = gson.fromJson(rawJsonData, BaseResp.class);
                return baseResp;
            }
            return null;
        }
    }
}
