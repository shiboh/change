package com.chnMicro.MFExchange.activity;

import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chnMicro.MFExchange.R;
import com.chnMicro.MFExchange.fragment.FountFramgnet;
import com.chnMicro.MFExchange.fragment.MoneyFragment;
import com.chnMicro.MFExchange.util.Prompter;

import java.util.List;

import butterknife.InjectView;
import butterknife.InjectViews;
import butterknife.OnClick;

/**
 * Created by Enel on 2015/1/26.
 * 主activity界面，包含若干fragment
 */
public class MainActivity extends BaseActivity {
    @InjectView(R.id.tab_money) LinearLayout tabMoney;
    @InjectView(R.id.tab_found) LinearLayout tabFound;
    @InjectView(R.id.tab_mine) LinearLayout tabMine;

    @InjectViews({R.id.tab_money, R.id.tab_found, R.id.tab_mine}) List<LinearLayout> tabs;
    private MoneyFragment moneyFragment;
    private FountFramgnet fountFramgnet;

    @Override protected void prepare() {

        Log.e("xxx", getLocalClassName() + " prepare()");
        moneyFragment = new MoneyFragment();
        fountFramgnet = new FountFramgnet();

    }

    @Override protected void setContentView() {
        setContentView(R.layout.activity_main);
//        Fragment
    }

    @Override protected void initViews() {
        initTabs();
        //TODO: 选中第一个

        //TODO: 设置topbar文字，有的在fragment里，有的在activity里
//        setTopbarText("充值", "我", "提现");
    }

    @Override protected void dealLogic() {

    }


    @OnClick({R.id.tab_money, R.id.tab_found, R.id.tab_mine})
    public void onTabClicked(LinearLayout tab) {
        initTabs();
        Prompter.toast(this, ((TextView) tab.getChildAt(1)).getText().toString());
        setTabSelected(tab);
        //TODO: 切换fragment

        switch (tab.getId()) {
            case R.id.tab_money:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, moneyFragment).commit();

                FragmentManager fManager = getSupportFragmentManager();
                FragmentTransaction fTransaction = fManager.beginTransaction();
                fTransaction.

                break;
            case R.id.tab_found:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fountFramgnet).commit();
                break;
            default:
                break;
        }


//        android.support.v4.app.Fragment


    }

    /**
     * 设置tab为选中状态，其他的为默认状态
     *
     * @param tab
     */
    public void setTabSelected(LinearLayout tab) {
        View icon = tab.getChildAt(0);
        View text = tab.getChildAt(1);

        Resources res = getResources();
        if (icon != null) {
            icon.setSelected(true);
        }
        if (text != null) {
            ((TextView) text).setTextColor(res.getColor(R.color.mifie_red));
        }
    }

    /**
     * 设置所有的tab的状态为默认值
     */
    private void initTabs() {
        for (LinearLayout tab : tabs) {
            initTab(tab);
        }
    }

    /**
     * 设置tab中图标和文字的状态为默认值
     *
     * @param tab
     */
    private void initTab(LinearLayout tab) {
        View icon = tab.getChildAt(0);
        View text = tab.getChildAt(1);

        Resources res = getResources();
        if (icon != null) {
            icon.setSelected(false);
        }
        if (text != null) {
            ((TextView) text).setTextColor(res.getColor(R.color.text_grey_light));
        }
    }
}
