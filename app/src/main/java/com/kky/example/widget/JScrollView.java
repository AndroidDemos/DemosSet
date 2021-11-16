package com.kky.example.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Author: Zeus
 * Date: 2021/5/20 10:41
 * Description:滚动布局，监听单击事件
 * History:
 */
public class JScrollView extends ScrollView implements GestureDetector.OnGestureListener {
    private GestureDetector gestureDetector;
    private ISingleTapListener listener;

    public JScrollView(Context context) {
        super(context);
        initDetector(context);
    }

    public JScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initDetector(context);
    }

    public void initDetector(Context context) {
        gestureDetector = new GestureDetector(context, this);
    }

    public void setTapListener(ISingleTapListener listener) {
        this.listener = listener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (!isEnabled()) {
            return super.onTouchEvent(ev);
        }
        if (gestureDetector.onTouchEvent(ev)) return true;
        return super.onTouchEvent(ev);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        if (listener != null) {
            listener.onSingle();
        }
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    public interface ISingleTapListener {
        public void onSingle();
    }
}
