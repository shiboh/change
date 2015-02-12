package com.chnMicro.MFExchange.activity;

import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chnMicro.MFExchange.R;
import com.chnMicro.MFExchange.fragment.BaseFragment;
import com.chnMicro.MFExchange.fragment.FoundFragmnet;
import com.chnMicro.MFExchange.fragment.MineFragment;
import com.chnMicro.MFExchange.fragment.MoneyFragment;
import com.chnMicro.MFExchange.util.Prompter;

import java.util.ArrayList;
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

    private FragmentManager fManager;
    ArrayList<BaseFragment> fragments;
    private MoneyFragment moneyFragment;
    private FoundFragmnet foundFragmnet;
    private MineFragment mineFragment;

    @Override protected void prepare() {
        fManager = getSupportFragmentManager();
        Log.e("xxx", getLocalClassName() + " prepare()");
        initFragments();
    }


    @Override protected void setContentView() {
        setContentView(R.layout.activity_main);
//        Fragment
    }

    @Override protected void initViews() {
        initTabTags();
        initTabs();
        //选中第一个
        tabs.get(0).performClick();

        //TODO: 设置topbar文字，有的在fragment里，有的在activity里
//        setTopbarText("充值", "我", "提现");
    }

    /**
     * 给tab设置上tag，tag为对应的fragment对象
     */
    private void initTabTags() {
        tabMoney.setTag(moneyFragment);
        tabFound.setTag(foundFragmnet);
        tabMine.setTag(mineFragment);
    }

    @Override protected void dealLogic() {

    }

    /**
     * 创建所有fragment对象，并添加到列表fragments里
     */
    private void initFragments() {
        moneyFragment = new MoneyFragment();
        foundFragmnet = new FoundFragmnet();
        mineFragment = new MineFragment();

        fragments = new ArrayList<>();
        fragments.add(moneyFragment);
        fragments.add(foundFragmnet);
        fragments.add(mineFragment);
    }

    @OnClick({R.id.tab_money, R.id.tab_found, R.id.tab_mine})
    public void onTabClicked(LinearLayout tab) {
        initTabs();
        Prompter.toast(this, ((TextView) tab.getChildAt(1)).getText().toString());
        setTabSelected(tab);
        //切换fragment
        BaseFragment fragment = (BaseFragment) tab.getTag();
        show(fragment);
    }

    /**
     * 显示指定fragment，其他fragment隐藏
     *
     * @param fragment
     */
    private void show(BaseFragment fragment) {
        FragmentTransaction transaction = fManager.beginTransaction();
        if (!fragment.isAdded()) {
            transaction.add(R.id.fragment_container, fragment, fragment.getClass().getSimpleName());
        }

        for (BaseFragment baseFragment : fragments) {
            if (fragment == baseFragment) {
                transaction.show(baseFragment);
            }else {
                transaction.hide(baseFragment);
            }
        }
        transaction.commit();
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
