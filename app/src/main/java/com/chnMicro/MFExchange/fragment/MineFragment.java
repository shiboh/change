package com.chnMicro.MFExchange.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.chnMicro.MFExchange.R;

/**
 * tab-“我”
 */
public class MineFragment extends BaseFragment {
    public MineFragment() {
    }

    @Override protected int getLayoutRes() {
        return R.layout.fragment_mine;
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTopbarText("", "我", "");
    }
}
