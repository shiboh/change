package com.chnMicro.MFExchange.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.LinearLayout;

import com.chnMicro.MFExchange.R;

import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoneyFragment extends BaseFragment {
    @InjectView(R.id.topbar) LinearLayout topbar;

    public MoneyFragment() {
        setLayoutRes(R.layout.fragment_money);        // Required empty public constructor
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTopbarText("", "理财", "");
    }
}
