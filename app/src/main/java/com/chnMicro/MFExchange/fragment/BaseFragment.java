package com.chnMicro.MFExchange.fragment;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chnMicro.MFExchange.R;
import com.chnMicro.MFExchange.util.LogUtil;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.Optional;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment {
    @Optional @InjectView(R.id.btn_topbar_left) TextView btnTopbarLeft;
    @Optional @InjectView(R.id.tv_topbar_middle) TextView tvTopbarMiddle;
    @Optional @InjectView(R.id.btn_topbar_right) TextView btnTopbarRight;

    /**
     * fragment对应的布局
     */
    private int layoutRes = -1;

    public BaseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layoutRes = getLayoutRes();
        if (layoutRes <= 0) {
            LogUtil.info("onCreateView");
            throw new IllegalArgumentException("field layoutRes should be set");
        }

        View view = inflater.inflate(layoutRes, container, false);
        ButterKnife.inject(this, view);
        setTopbarTypeface();
        return view;
    }

    @Override public void onDestroy() {
        super.onDestroy();
        ButterKnife.reset(this);
    }

    /**
     * 设置topbar字体
     */
    private void setTopbarTypeface() {
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "fonts/fangzheng.ttf");
        if (btnTopbarLeft != null) btnTopbarLeft.setTypeface(tf);
        if (tvTopbarMiddle != null) tvTopbarMiddle.setTypeface(tf);
        if (btnTopbarRight != null) btnTopbarRight.setTypeface(tf);
    }

    /**
     * 在子类中指定layout资源id
     */
    protected abstract int getLayoutRes();

    /**
     * 设置topbar左、中、右三个文本
     */
    protected void setTopbarText(String left, String middle, String right) {
        if (btnTopbarLeft != null) btnTopbarLeft.setText(left);
        if (tvTopbarMiddle != null) tvTopbarMiddle.setText(middle);
        if (btnTopbarRight != null) btnTopbarRight.setText(right);
    }
}
