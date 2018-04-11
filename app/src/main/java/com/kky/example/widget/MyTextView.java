package com.kky.example.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

public class MyTextView extends android.support.v7.widget.AppCompatTextView {
    //    private String tag = this.getClass().getSimpleName();
    private String tag = "MyTextView";

    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                Log.i(tag, "dispatchTouchEvent   ACTION_UP");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(tag, "dispatchTouchEvent   ACTION_MOVE");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.i(tag, "dispatchTouchEvent   ACTION_DOWN");
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                Log.i(tag, "onTouchEvent   ACTION_UP");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(tag, "onTouchEvent   ACTION_MOVE");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.i(tag, "onTouchEvent   ACTION_DOWN");
                break;
        }
        return super.onTouchEvent(event);
    }


}
