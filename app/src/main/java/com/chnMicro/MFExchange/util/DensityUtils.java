package com.chnMicro.MFExchange.util;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by Enel on 2015/1/26.
 */
public class DensityUtils {
    /**
     * 屏幕宽度，单位px
     */
    public static int getDisplayWidthPx(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    /**
     * 屏幕高度，单位px
     */
    public static int getDisplayHeightPx(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }

}
