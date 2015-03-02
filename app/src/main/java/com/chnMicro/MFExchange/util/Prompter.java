package com.chnMicro.MFExchange.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Enel on 2015/2/5.
 * <p/>
 * 各种“提示”
 */
public class Prompter {
    private Prompter() {
    }

    public static void toast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void toast(Context context, int strId) {
        Toast.makeText(context, strId, Toast.LENGTH_SHORT).show();
    }

}
