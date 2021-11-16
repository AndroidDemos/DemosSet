package com.eus.flex;

import android.app.Application;
import android.content.Context;

/**
 * Author: Zeus
 * Date: 2021/1/26 16:35
 * Description:
 * History:
 */
public class MyApplication extends Application {
    private static Context sContext;

    public static Context getContext() {
        return sContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }
}
