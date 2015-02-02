package com.chnMicro.MFExchange.activity;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chnMicro.MFExchange.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.MySSLSocketFactory;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import butterknife.InjectView;
import butterknife.OnClick;

public class SplashActivity extends BaseActivity {
    @InjectView(R.id.tv_resp) TextView tvResp;
    private AsyncHttpClient myAsyncHttpClient;

    @Override protected void prepare() {

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
            @Override public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
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
//TODO: 构造请求参数
        client.post(url_https, new AsyncHttpResponseHandler() {
            @Override public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String msg = "statusCode:" + statusCode + "\n" + new String(responseBody);
                tvResp.setText(msg);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                String msg = "statusCode:" + statusCode + "\n" + String.valueOf(responseBody) + "\n" + error.getMessage();
                tvResp.setText(msg);
            }
        });
    }

    @Override protected void setContentView() {
        setContentView(R.layout.activity_splash);
    }

    @Override protected void initViews() {
    }

    @Override protected void initData() {
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
