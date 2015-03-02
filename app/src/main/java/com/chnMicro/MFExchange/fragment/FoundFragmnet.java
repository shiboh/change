package com.chnMicro.MFExchange.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.chnMicro.MFExchange.R;

/**
 * tab-“发现”
 */
public class FoundFragmnet extends BaseFragment {

    public FoundFragmnet() {
    }

    @Override protected int getLayoutRes() {
        return R.layout.fragment_found;
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTopbarText("", "发现", "");
    }
}
