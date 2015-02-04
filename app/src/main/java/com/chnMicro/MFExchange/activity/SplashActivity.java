package com.chnMicro.MFExchange.activity;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chnMicro.MFExchange.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.MySSLSocketFactory;
import com.loopj.android.http.TextHttpResponseHandler;

import org.apache.http.Header;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
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
        AsyncHttpClient client = getMyAsyncHttpClient();
        //构造请求参数
        JSONObject infoJson = new JSONObject();
        JSONObject authJson = new JSONObject();
//        {"loginPwd":"MTExMTEx\n","username":"13717776061"}
//        {"appver":"2.0.4","base64":1,"osver":"4.1.1","source":5,"vendor":100000,"version":20}
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

        //TODO: BaseJsonHttpResp....
        //TODO: JsonHttpResp...
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

        client.post(SplashActivity.this, url_https, entity, "application/x-www-form-urlencoded", new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                String msg = "statusCode:" + statusCode + "\n" + responseString + "\n" + throwable.getMessage();
                tvResp.setText(msg);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                String msg = "statusCode:" + statusCode + "\n" + responseString;
                tvResp.setText(msg);
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
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
