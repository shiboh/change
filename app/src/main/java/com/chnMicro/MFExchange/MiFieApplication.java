package com.chnMicro.MFExchange;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Enel on 2015/1/26.
 */
public class MiFieApplication extends Application {
    public static boolean isLogin = false;

    public static Context context;

    public MiFieApplication() {
        super();
        context = this;
    }

    /**
     * 整个app共用的gson
     */
    public static Gson gson;

    @Override public void onCreate() {
        super.onCreate();
        gson = new GsonBuilder().create();
    }
}
