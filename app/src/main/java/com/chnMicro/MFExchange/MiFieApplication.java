package com.chnMicro.MFExchange;

import android.app.Application;
import android.content.Context;

/**
 * Created by Enel on 2015/1/26.
 */
public class MiFieApplication extends Application {
    public static Context context;
    public MiFieApplication(){
        super();
        context = this;
    }

    public static boolean isLogin = false;
}
