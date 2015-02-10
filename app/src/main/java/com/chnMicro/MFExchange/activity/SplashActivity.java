package com.chnMicro.MFExchange.activity;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chnMicro.MFExchange.R;
import com.chnMicro.MFExchange.Request;
import com.chnMicro.MFExchange.RequestMaker;
import com.chnMicro.MFExchange.WJSClient;
import com.chnMicro.MFExchange.bean.BaseResp;
import com.chnMicro.MFExchange.bean.UserInfo;
import com.google.gson.JsonObject;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.MySSLSocketFactory;

import org.apache.http.Header;

import java.security.KeyStore;

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
        Request request = RequestMaker.getLoginReq("13717776061", "MTExMTEx\\n");
        post(request, new WJSClient.WJSBaseJsonHttpResponseHandler() {

            @Override protected void onRealSuccess(BaseResp response) {
                JsonObject result = response.result;
                UserInfo userInfo = gson.fromJson(result, UserInfo.class);
            }
        });

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
