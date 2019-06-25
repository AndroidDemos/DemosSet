package com.kky.example.mevent.d2.custom.dep;

import android.util.Log;

import com.kky.example.mevent.d2.custom.Hero;

/*
 * @author Zeus
 * create at 2019/5/10 11:40
 * modify at 2019/5/10 11:40
 * modify because
 * description: 基于接口方式
 */
public class Self2 implements InjectInterface {
    Hero hero;

    @Override
    public void injectHero(Hero hero) {
        this.hero = hero;
    }

    public void help(){
        String call = hero.call();
        Log.d("callMessage", call);
    }
}
