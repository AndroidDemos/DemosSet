package com.kky.example.util.app;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * Author: Zeus
 * Date: 2021/8/11 12:00
 * Description: 监听应用整个生命周期
 * History:
 */
public class ProcessLifecycleObserver implements LifecycleObserver {
    /**
     * 当app变成前台进程时监听
     * 此方法一次app进入退出只会调用一次
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void enterAppListener(){
        Log.e("ProcessLifecycle","ON_CREATE");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void startAppListener(){
        Log.e("ProcessLifecycle","ON_START");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void resumeAppListener(){
        Log.e("ProcessLifecycle","ON_RESUME");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void pauseAppListener(){
        Log.e("ProcessLifecycle","ON_PAUSE");
    }
    /**
     * 当app变成后台进程或者退出调用
     * 此方法一次app进入退出只会调用一次
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void exitAppListener(){
        Log.e("ProcessLifecycle","ON_STOP");
    }
}
