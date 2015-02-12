package com.chnMicro.MFExchange.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chnMicro.MFExchange.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoundFragmnet extends BaseFragment {


    public FoundFragmnet() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.e("xxx", getClass().getSimpleName() + " created");
        return inflater.inflate(R.layout.fragment_fount, container, false);
    }


}
