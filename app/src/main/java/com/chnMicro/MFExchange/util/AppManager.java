package com.chnMicro.MFExchange.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;

/**
 * Created by Enel on 2015/1/26.
 * 管理所有Activity，用于app退出
 */
public class AppManager {
    //单例
    private static AppManager ourInstance = new AppManager();

    public static AppManager getInstance() {
        return ourInstance;
    }

    private AppManager() {
    }

    private static Stack<Activity> activityStack = new Stack<>();

    /**
     * 添加activity
     */
    public void add(Activity activity) {
        activityStack.add(activity);
    }

    /**
     * 当前（栈顶）activity
     */
    public Activity current() {
        if (activityStack.empty()) {
            return null;
        }
        return activityStack.peek();
    }

    /**
     * finish栈顶activity
     */
    public void finish() {
        Activity activity = activityStack.lastElement();
        finish(activity);
    }

    /**
     * finish指定activity
     */
    private void finish(Activity activity) {
        if (!activityStack.empty() && activity != null) {
            activityStack.remove(activity);
            activity.finish();
        }
    }

    /**
     * finish所有activity，
     */
    public void finishAll() {
        for (Activity activity : activityStack) {
            if (activity != null) {
                finish(activity);
            }
            activityStack.clear();
        }
    }

    /**
     * 退出app
     */
    public void exit(Context context) {
        try {
            finishAll();
            ActivityManager activityMgr = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.killBackgroundProcesses(context.getPackageName());
            System.exit(0);
            android.os.Process.killProcess(android.os.Process.myPid());
        } catch (Exception e) {

        }
    }
}