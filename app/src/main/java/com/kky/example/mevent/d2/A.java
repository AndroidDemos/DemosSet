package com.kky.example.mevent.d2;

import javax.inject.Inject;

/*
 * @author Zeus
 * create at 2019/1/14 14:48
 * modify at 2019/1/14 14:48
 * modify because
 * description: TO FIT
 */
public class A {
    @Inject
    B b;
    @Inject
    C c;

    @Inject
    public A() {
    }

    public String xxoo() {
        String resuls = "";
        String x = "翠花，关灯。。。\n";

        resuls = x + b.birthSon();
        return resuls;
    }

    public String appointment() {
        String result = "";
        String x = "上官无雪，晚上一起去看看月亮聊聊理想啊？\n";
        result = x + c.turnDown();
        return result;
    }
}
