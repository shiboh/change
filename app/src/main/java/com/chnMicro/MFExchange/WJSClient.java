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

import java.security.KeyStore;

/**
 * Created by Enel on 2015/2/5.
 */
public class WJSClient {
    private static Context context = MiFieApplication.context;
    private static final String BASE_URL = Constants.HOST;
    private static AsyncHttpClient client = new AsyncHttpClient();

    static {
        client = getMyAsyncHttpClient();
        LogUtil.info("static block been executed");
    }

    public static void post(Context context, String api, HttpEntity entity, ResponseHandlerInterface responseHandler) {
        client.post(context, getAbsoluteUrl(api), entity, "", responseHandler);
    }

    public static String getAbsoluteUrl(String api) {
        return BASE_URL + api;
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

    public abstract static class WJSBaseJsonHttpResponseHandler extends BaseJsonHttpResponseHandler<BaseResp> {
        @Override
        public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, BaseResp response) {
            LogUtil.info(rawJsonResponse);

            if (response.needButNotLogin()) {
                //TODO: 跳转到登录界面
                Prompter.toast(context, "jump to LoginActivity");
            }

            //业务操作失败，toast失败提示
            if (response.failure()) {
                LogUtil.info(WJSClient.class, "context:" + (context == null ? "null" : "not null") + ",response.message:" + (response.message == null ? "null" : "not null"));

                Prompter.toast(context, response.message);
            }

            //TODO: 处理业务逻辑
            //TODO: 回调？？
            onRealSuccess(rawJsonResponse, response);
        }

        /**
         * 真·业务逻辑
         */
        protected abstract void onRealSuccess(String rawJsonResponse, BaseResp response);

        @Override
        public void onFailure(int statusCode, Header[] headers, Throwable throwable, String rawJsonData, BaseResp errorResponse) {
            Prompter.toast(context, R.string.msg_error_network);
        }

        @Override
        protected BaseResp parseResponse(String rawJsonData, boolean isFailure) throws Throwable {
            if (!isFailure) {
                //TODO: 公共gson实例
                Gson gson = new Gson();
                BaseResp baseResp = gson.fromJson(rawJsonData, BaseResp.class);
                return baseResp;
            }
            return null;
        }
    }
}
