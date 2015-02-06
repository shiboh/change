package com.chnMicro.MFExchange.activity;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chnMicro.MFExchange.R;
import com.chnMicro.MFExchange.WJSClient;
import com.chnMicro.MFExchange.bean.BaseResp;
import com.chnMicro.MFExchange.util.Prompter;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.MySSLSocketFactory;

import org.apache.http.Header;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

public class SplashActivity extends BaseActivity {
    @InjectView(R.id.tv_resp)
    TextView tvResp;
    private AsyncHttpClient myAsyncHttpClient;

    @Override
    protected void prepare() {
    }

    @OnClick(R.id.btn_http)
    public void testHttp(View view) {
        Toast.makeText(this, "http", Toast.LENGTH_SHORT).show();
        postByHttp();
    }

    @OnClick(R.id.btn_https)
    public void testHttps(View view) {
        Toast.makeText(this, "https", Toast.LENGTH_SHORT).show();
        postByHttps();
    }

    private final String url_http = "http://www.baidu.com";
    private final String url_https = "https://interface.weijinsuo.com:8999/loginUser.do";

    private void postByHttp() {
//        Context context = new MiFieApplication();
        Context context = getApplication();
        Context applicationContext = getApplicationContext();

        if (context == applicationContext) {
            Toast.makeText(context, "yes", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "no", Toast.LENGTH_SHORT).show();
        }


        AsyncHttpClient client = new AsyncHttpClient();

        client.post(url_http, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                tvResp.setText("statusCode:" + statusCode + "\n" + new String(responseBody));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                tvResp.setText("statusCode:" + statusCode + "\n" + String.valueOf(responseBody) + "\n" + error.getMessage());
            }
        });

    }

    private void postByHttps() {
        //构造请求参数
        JSONObject infoJson = new JSONObject();
        JSONObject authJson = new JSONObject();
        try {
            infoJson.put("loginPwd", "MTExMTEx\\n")
                    .put("username", "13717776061");
            authJson.put("appver", "2.0.4")
                    .put("base64", 1)
                    .put("osver", "4.1.1")
                    .put("source", 5)
                    .put("vendor", 100000)
                    .put("version", 20);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        UrlEncodedFormEntity entity = null;
        try {
            List<BasicNameValuePair> params = new ArrayList<>();
            BasicNameValuePair info = new BasicNameValuePair("info", infoJson.toString());
            BasicNameValuePair auth = new BasicNameValuePair("auth", authJson.toString());
            params.add(info);
            params.add(auth);
            entity = new UrlEncodedFormEntity(params, HTTP.UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        WJSClient.post(SplashActivity.this, "/loginUser.do", entity, new WJSClient.WJSBaseJsonHttpResponseHandler() {
            @Override protected void onRealSuccess(String rawJsonResponse, BaseResp response) {
                //TODO: 业务逻辑
                Prompter.toast(SplashActivity.this, "真·业务逻辑");
            }
        });


        //by BaseJsonHttpResponseHandler
//        WJSClient.post(SplashActivity.this, "/loginUser.do", entity, new BaseJsonHttpResponseHandler<HashMap>() {
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, HashMap response) {
//                LogUtil.info(statusCode + ":" + response.toString());
//            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, Throwable throwable, String rawJsonData, HashMap errorResponse) {
//                LogUtil.info(statusCode + ":" + errorResponse.toString());
//            }
//
//            @Override
//            protected HashMap parseResponse(String rawJsonData, boolean isFailure) throws Throwable {
//                if (!isFailure) {
//                    Gson gson = new Gson();
//                    HashMap hashMap = gson.fromJson(rawJsonData, HashMap.class);
//                    return hashMap;
//                }
//                return new HashMap();
//            }
//        });

        //by JsonHttpResponseHandler
//        client.post(SplashActivity.this, url_https, entity, "application/x-www-form-urlencoded", new JsonHttpResponseHandler(){
//            @Override public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
//                LogUtil.info(response.toString());
//            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
//                LogUtil.info(throwable.getMessage());
//            }
//
//            @Override protected Object parseResponse(byte[] responseBody) throws JSONException {
//                return super.parseResponse(responseBody);
//            }
//        });

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void initViews() {
    }

    @Override
    protected void initData() {
    }

    /**
     * 创建自定义client，可以http、https
     */
    public AsyncHttpClient getMyAsyncHttpClient() {

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
}
