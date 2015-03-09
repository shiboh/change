package com.chnMicro.MFExchange.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.chnMicro.MFExchange.R;
import com.chnMicro.MFExchange.Request;
import com.chnMicro.MFExchange.RequestMaker;
import com.chnMicro.MFExchange.WJSClient;
import com.chnMicro.MFExchange.bean.BaseResp;
import com.chnMicro.MFExchange.bean.Loan;
import com.chnMicro.MFExchange.util.LogUtil;
import com.chnMicro.MFExchange.view.LoanCircleProgress;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * tab-“理财”
 */
public class MoneyFragment extends BaseFragment {
    //TODO:改为从api获取
    public static final String[] typeNames = {"微金所", "推荐", "微投资", "微小宝", "微票宝", "微转让"};
    private List<Loan> loanList;

    @InjectView(R.id.pager) ViewPager pager;

    public MoneyFragment() {
    }

    @Override protected int getLayoutRes() {
        return R.layout.fragment_money;
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTopbarText("", "理财", "");

        FragmentManager fm = getFragmentManager();
        MoneyFragmentPagerAdapter adapter = new MoneyFragmentPagerAdapter(fm);
        pager.setAdapter(adapter);

    }

    private class MoneyFragmentPagerAdapter extends FragmentPagerAdapter{
        public MoneyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override public Fragment getItem(int position) {
            TypedMoneyFragment fragment = new TypedMoneyFragment();
            Bundle args = new Bundle();
            //TODO: 处理产品类型与值的对应关系
            //TODO: 由接口配置产品类型与顺序，改为可扩展的(接口需要返回各产品类型列表的api)
            args.putInt(TypedMoneyFragment.MONEY_TYPE, position);
            fragment.setArguments(args);
            return fragment;
        }

        @Override public int getCount() {
            return typeNames.length;
        }
    }

}
