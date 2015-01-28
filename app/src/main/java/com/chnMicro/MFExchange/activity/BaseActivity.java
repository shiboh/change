package com.chnMicro.MFExchange.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.chnMicro.MFExchange.MiFieApplication;
import com.chnMicro.MFExchange.R;
import com.chnMicro.MFExchange.util.AppManager;
import com.chnMicro.MFExchange.util.DensityUtils;

import butterknife.ButterKnife;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by Enel on 2015/1/26.
 */
public abstract class BaseActivity extends SwipeBackActivity {
    public static final String INTENT_MODE = "mode";    //跳转时可能带
    public boolean needLogin = false;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //添加当前activity进AppManager中的activity栈
        AppManager.getInstance().add(this);
        //TODO:透明状态栏
        //ButterKnife注入
//        ButterKnife.inject(this);
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

    @Override protected void onDestroy() {
        super.onDestroy();

        AppManager.getInstance().finish();
    }

}
