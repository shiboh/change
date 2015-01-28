package com.chnMicro.MFExchange.activity;

import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chnMicro.MFExchange.R;

import butterknife.InjectView;
import butterknife.OnClick;

public class SplashActivity extends BaseActivity {
    @InjectView(R.id.btn) Button btn;

    @Override protected void prepare() {

    }

    @OnClick(R.id.btn)
    public void jump2B(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }


    @Override protected void setContentView() {
        setContentView(R.layout.activity_splash);
    }

    @Override protected void initViews() {
        btn.setText("this is A");

    }

    @Override protected void initData() {

    }


}
