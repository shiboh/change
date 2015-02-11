package com.chnMicro.MFExchange.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;

import com.chnMicro.MFExchange.R;

public class SplashActivity extends BaseActivity {

    @Override protected void prepare() {
        statusBarColor = Color.TRANSPARENT;
    }

    @Override protected void setContentView() {
        setContentView(R.layout.activity_splash);
    }

    @Override protected void initViews() {

    }

    @Override protected void dealLogic() {
        //TODO: 改为 3000ms
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 300);
    }
}
