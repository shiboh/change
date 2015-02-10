package com.chnMicro.MFExchange.activity;

import android.view.View;
import android.widget.Toast;

import com.chnMicro.MFExchange.R;

/**
 * Created by Enel on 2015/1/26.
 * 主activity界面，包含若干fragment
 */
public class MainActivity extends BaseActivity {

    @Override protected void prepare() {
    }

    @Override protected void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override protected void initViews() {
        setTopbarText("充值", "我", "提现");
    }

    @Override protected void dealLogic() {

    }

    @Override public void onTopbarLeftClicked(View view) {
        Toast.makeText(this, "left clicked", Toast.LENGTH_SHORT).show();
    }

    @Override public void onTopbarRightClicked(View view) {
        Toast.makeText(this, "right clicked", Toast.LENGTH_SHORT).show();
    }
}
