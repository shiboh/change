package com.chnMicro.MFExchange.activity;

import android.graphics.Typeface;
import android.widget.TextView;

import com.chnMicro.MFExchange.R;

import butterknife.InjectView;

/**
 * Created by Enel on 2015/1/26.
 */
public class MainActivity extends BaseActivity {
    @InjectView(R.id.tv_topbar_left) TextView tvTopbarLeft;
    @InjectView(R.id.tv_topbar_medium) TextView tvTopbarMedium;
    @InjectView(R.id.tv_topbar_right) TextView tvTopbarRight;

    @Override protected void prepare() {

    }

    @Override protected void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override protected void initViews() {
        Typeface tf
        tvTopbarLeft.setTypeface(tf);



    }

    @Override protected void initData() {

    }
}
