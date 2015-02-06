package com.chnMicro.MFExchange.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Enel on 2015/2/5.
 *
 * 各种“提示”
 */
public class Prompter {
    public static void toast(Context context, String msg) {
        LogUtil.info("context:" + (context == null ? "null" : "not null") + ",msg:" + (msg == null ? "null" : "not null"));
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void toast(Context context, int strId) {
        Toast.makeText(context, strId, Toast.LENGTH_SHORT).show();
    }



}
