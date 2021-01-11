package com.example.appcolorconfig

import android.app.Activity
import android.graphics.Rect
import android.view.ViewTreeObserver

object ScrollHideHelp {
    private var mWindowHeight = 0
    fun addScrollListener(activity: Activity, listeren: ScrollViewListener) {
        activity.window.decorView.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                var r = Rect()
                //获取当前窗口实际的可见区域
                activity.window.decorView.getWindowVisibleDisplayFrame(r)
                var height = r.height()
                if (mWindowHeight == 0) {
                    //一般情况下，这是原始的窗口高度
                    mWindowHeight = height
                    listeren.onShow(1)
                } else {
                    if (mWindowHeight != height) {
                        listeren.onShow(0)
                        //两次窗口高度相减，就是软键盘高度
                        var softKeyboardHeight = mWindowHeight - height
                    } else {
                        listeren.onShow(1)
                    }
                }
            }

        })
    }

    interface ScrollViewListener {
        fun onShow(state: Int)//0隐藏1显示
    }
}