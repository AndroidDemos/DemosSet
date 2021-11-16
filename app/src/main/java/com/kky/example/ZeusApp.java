package com.kky.example;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;


import androidx.lifecycle.ProcessLifecycleOwner;

import com.kky.example.libnet.NetWorkManager;
import com.kky.example.util.LocalPrinter;
import com.kky.example.util.app.ProcessLifecycleObserver;
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

    private int activityCount = 100;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        Logger.addLogAdapter(new AndroidLogAdapter());
        NetWorkManager.getInstance().init();
//        acLifecycleCallbacks();
//        lifeCycleObserver();
//        fullLifeCycleObserver();
    }

    private void fullLifeCycleObserver() {
        ProcessLifecycleOwner.get().getLifecycle().addObserver(new ProcessLifecycleObserver());
    }

    private void lifeCycleObserver() {
        ProcessLifecycleOwner.get().getLifecycle().addObserver(new ProcessLifecycleObserver());
    }

    private void acLifecycleCallbacks() {//只能监听单个Activity的状态
        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                activityCount++;
                LocalPrinter.printLocal("onActivityCreated count--" + activityCount);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                activityCount--;
                LocalPrinter.printLocal("ActivityLifecycleCallbacks onActivityDestroyed");
                if (activityCount == 0) {
                    LocalPrinter.printLocal("ActivityLifecycleCallbacks onAppExit");
                }
            }
        });
    }
}
