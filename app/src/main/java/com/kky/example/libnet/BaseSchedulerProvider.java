package com.kky.example.libnet;

import androidx.annotation.NonNull;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;

/*
 * @author Zeus
 * create at 2019/1/15 16:30
 * modify at 2019/1/15 16:30
 * modify because
 * description: TO FIT
 */
public interface BaseSchedulerProvider {
    @NonNull
    Scheduler computation();

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();

    @NonNull
    <T> ObservableTransformer<T, T> applySchedulers();
}
