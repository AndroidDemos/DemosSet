package com.kky.example;

import android.app.Application;
import android.content.Context;

import com.kky.example.libnet.NetWorkManager;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/5/25 14:47
 * @change time
 * @class describe
 */
public class ZeusApp extends android.app.Application {
    private static Application application = null;

    public static Context getContext() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        Logger.addLogAdapter(new AndroidLogAdapter());
        NetWorkManager.getInstance().init();
    }
}
