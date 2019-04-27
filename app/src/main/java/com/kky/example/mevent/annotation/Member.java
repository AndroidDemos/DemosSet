package com.kky.example.mevent.annotation;

import android.util.Log;

import androidx.annotation.NonNull;

/*
 * @author Zeus
 * create at 2019/1/14 16:49
 * modify at 2019/1/14 16:49
 * modify because
 * description: TO FIT
 */
@Table(name = "MEMBER")
public class Member {
    @ZTest
    public void method() {
        Log.i("annotition-tag", this.toString());
    }

    @NonNull
    @Override
    public String toString() {

        return super.toString();
    }
}
