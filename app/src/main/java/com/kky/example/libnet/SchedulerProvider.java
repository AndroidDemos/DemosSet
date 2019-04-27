package com.kky.example.libnet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/*
 * @author Zeus
 * create at 2019/1/15 16:29
 * modify at 2019/1/15 16:29
 * modify because
 * description: TO FIT
 */
public class SchedulerProvider implements BaseSchedulerProvider {
    @Nullable
    private static SchedulerProvider INSTANCE;

    public static synchronized SchedulerProvider getInstance() {
        if (INSTANCE == null) {
            synchronized (SchedulerProvider.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SchedulerProvider();
                }
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @NonNull
    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @NonNull
    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }

    @NonNull
    @Override
    public <T> ObservableTransformer<T, T> applySchedulers() {
        return observable -> observable.subscribeOn(io()).observeOn(ui());
    }
}
