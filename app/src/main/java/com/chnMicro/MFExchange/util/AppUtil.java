package com.chnMicro.MFExchange.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.chnMicro.MFExchange.MiFieApplication;

/**
 * Created by Enel on 2015/2/9.
 */
public class AppUtil {
    private static Context context = null;

    private AppUtil() {
    }

    static {
        context = MiFieApplication.context;
    }

    /**
     * @return app版本号
     */
    public static String getAppVersionName() {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String versionName = packageInfo.versionName;
            return versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
