package com.kky.example.mevent.d2;

import android.app.Activity;

import dagger.Component;

/*
 * @author Zeus
 * create at 2019/1/14 14:49
 * modify at 2019/1/14 14:49
 * modify because
 * description: TO FIT
 */
@Component(modules = {MainModule.class})
public interface MainComponent {
    void activityInject(D2Simple1Activity activity);
}
