package com.kky.example.mevent.d2.custom;

import android.util.Log;

/*
 * @author Zeus
 * create at 2019/5/10 10:26
 * modify at 2019/5/10 10:26
 * modify because
 * description: TO FIT
 */
//每次变动都要修改Self类，这里Self一直依赖一个英雄类，英雄更换了要修改，英雄的构造函数变了也要修改Self类，这样耦合就非常严重。
public class Self {
    private IronMan ironMan;

    public Self() {
        ironMan = new IronMan();
    }

    public void help(){
        String call = ironMan.call();
        Log.d("callMessage",call);//这里有个问题就是假如英雄有事情，变更成本太大。。
    }
}
