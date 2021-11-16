package com.kky.example.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/4/24 17:44
 * @change time
 * @class describe
 */
public class MyRelativeLayout extends RelativeLayout {

    private final static String tag = "MyRelativeLayout";

    public MyRelativeLayout(Context context) {
        super(context);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_UP:
                Log.i(tag, "dispatchTouchEvent ACTION_UP");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(tag, "dispatchTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.i(tag, "dispatchTouchEvent ACTION_DOWN");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_UP:
                Log.i(tag, "onInterceptTouchEvent ACTION_UP");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(tag, "onInterceptTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.i(tag, "onInterceptTouchEvent ACTION_DOWN");
                break;
        }
        return super.onInterceptTouchEvent(ev);
//        return true;拦截后，子控件无法收到事件
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                Log.i(tag, "onTouchEvent ACTION_UP");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(tag, "onTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.i(tag, "onTouchEvent ACTION_DOWN");
                break;
        }
        return super.onTouchEvent(event);
    }
}
