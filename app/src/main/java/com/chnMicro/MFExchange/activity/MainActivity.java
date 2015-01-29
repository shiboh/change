package com.chnMicro.MFExchange.activity;

import android.view.View;
import android.widget.Button;

import com.chnMicro.MFExchange.R;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Enel on 2015/1/26.
 */
public class MainActivity extends BaseActivity {
    @InjectView(R.id.btn) Button btn;

    @Override protected void prepare() {

    }

    @Override protected void setContentView() {
        setContentView(R.layout.activity_splash);
    }

    @Override protected void initViews() {
        btn.setText("this is B");
    }

    @Override protected void initData() {

    }

    @OnClick(R.id.btn)
    public void go2C(View v) {
//        Intent intent = new Intent(this, CActivity.class);
//        startActivity(intent);
    }

}
