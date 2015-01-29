package com.chnMicro.MFExchange.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.chnMicro.MFExchange.MiFieApplication;
import com.chnMicro.MFExchange.R;
import com.chnMicro.MFExchange.util.AppManager;
import com.chnMicro.MFExchange.util.DensityUtils;
import com.chnMicro.MFExchange.util.LogUtil;

import butterknife.ButterKnife;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by Enel on 2015/1/26.
 */
public abstract class BaseActivity extends SwipeBackActivity {
    public static final String INTENT_MODE = "mode";    //跳转时可能带
    private final AppManager appManager = AppManager.getInstance();
    public boolean needLogin = false;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //转场动画
        if (!(this instanceof SplashActivity)) {
            overridePendingTransition(R.anim.activity_scroll_from_right, R.anim.activity_fadeout);
        }
        //添加当前activity到栈中
        appManager.add(this);
        //栈底activity不能滑动返回
        if (1 == appManager.count()) {
            setSwipeBackEnable(false);
        }
        //需要登录且未登录，则跳转到登录界面
        if (needLogin && !MiFieApplication.isLogin) {
            //TODO: 登录
            //startActivityForResult();
        }
        prepare();
        setContentView();
        beforeInitViews();
        initViews();
        initData();
    }

    private void beforeInitViews() {
        //滑动返回设置为全屏手势
        SwipeBackLayout sbLayout = getSwipeBackLayout();
        sbLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        sbLayout.setEdgeSize(DensityUtils.getDisplayWidthPx(this));
        sbLayout.setScrimColor(Color.TRANSPARENT);

        //ButterKnife注入
        ButterKnife.inject(this);
        //设置状态栏颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            setStatusBarColor(android.R.id.content);
            Integer statusColor = getResources().getColor(R.color.mifie_red);
            setStatusBarColor(statusColor);
        }
    }

    /**
     * 设置状态栏颜色
     */
    private void setStatusBarColor(int color) {
        int flags = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION | WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        getWindow().addFlags(flags);

        int statusBarHeight = getStatusBarHeight(this);
        View view = new View(this);
        view.setBackgroundColor(color);

        ViewGroup parent = (ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content);//parent是setContentView（content）中content的父view
        parent.addView(view, ViewGroup.LayoutParams.MATCH_PARENT, statusBarHeight);
        parent.getChildAt(0).setPadding(0, statusBarHeight, 0, 0);
    }

    /**
     * 获取状态栏高度
     */
    private int getStatusBarHeight(Context context) {
        int id = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimen = 0;
        if (id > 0)
            dimen = getResources().getDimensionPixelSize(id);
        return dimen;
    }


    /**
     * 获取intent中的信息、检查登录状态等
     */
    protected abstract void prepare();

    protected abstract void setContentView();

    protected abstract void initViews();

    protected abstract void initData();

    @Override protected void onPause() {
        super.onPause();
        //转场动画
        if (1 != appManager.count()) {
            overridePendingTransition(R.anim.activity_fadein, R.anim.activity_scroll_to_right);
        }
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        appManager.finish();
    }

    private long exitTime = 0;

    @Override public void onBackPressed() {
        //最后一个activity时，连击两次back键退出
        LogUtil.info("AppManager.getInstance().count() : " + appManager.count());
        if (1 == appManager.count()) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(this, "再按一次退出" + getString(R.string.app_name), Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                super.onBackPressed();
            }
        } else {
            super.onBackPressed();
        }
    }
}
