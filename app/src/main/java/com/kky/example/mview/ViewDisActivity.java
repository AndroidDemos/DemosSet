package com.kky.example.mview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.kky.example.R;
import com.kky.example.base.activity.BaseActivity;
import com.kky.example.base.fragment.BaseFragment;
import com.kky.example.widget.MyTextView;

import org.jetbrains.annotations.Nullable;

public class ViewDisActivity extends BaseActivity implements View.OnClickListener, View.OnTouchListener {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private String tag;
    private MyTextView myTextView;

    public ViewDisActivity() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_dis);
        tag = getTAG();
        myTextView = findViewById(R.id.m_tv);
        myTextView.setOnClickListener(this);
        myTextView.setOnTouchListener(this);
        AppCompatActivity appCompatActivity;
    }

    @Override
    public void onClick(View v) {
        Log.i(tag, "MyTextView onClick");
    }

    //activity 触碰事件
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                Log.i(tag, "MyTextView onTouch ACTION_UP");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(tag, "MyTextView onTouch ACTION_MOVE");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.i(tag, "MyTextView onTouch ACTION_DOWN");
                break;
        }
        return false;//执行Activity中的MyTextView的OnTouchEvent   故事的起源 step**3  如果返回false,执行MyTextView的onTouchEvent
    }

    //activity的事件分发   故事的起源 step**1
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
        return super.dispatchTouchEvent(ev);//不处理继续 --传给当前view的同名方法（此处MyTextView的dispatchTouchEvent）
    }

    //activity事件消费
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
