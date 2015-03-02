package com.chnMicro.MFExchange.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;

import com.chnMicro.MFExchange.R;

import butterknife.InjectView;

/**
 * tab-“理财”
 */
public class MoneyFragment extends BaseFragment {
    @InjectView(R.id.lv) ListView lv;

    public MoneyFragment() {
    }

    @Override protected int getLayoutRes() {
        return R.layout.fragment_money;
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTopbarText("", "理财", "");
    }
}
