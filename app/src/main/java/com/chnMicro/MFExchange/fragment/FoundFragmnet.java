package com.chnMicro.MFExchange.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.chnMicro.MFExchange.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoundFragmnet extends BaseFragment {

    public FoundFragmnet() {
        setLayoutRes(R.layout.fragment_found);
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTopbarText("", "发现", "");
    }
}
