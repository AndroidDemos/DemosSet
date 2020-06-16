package com.kky.example.widget.layout

import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import android.widget.LinearLayout

class ResizeLayout : LinearLayout {
    companion object {
        val KEYBORAD_HIDE = 0
        val KEYBORAD_SHOW = 1
    }

    private val SOFTKEYPAD_MIN_HEIGHT = 50
    private val uiHandler: Handler = Handler()
    private var keyBordStateListener: KeyBordStateListener? = null

    constructor(context: Context) : super(context) {}

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {

    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {//使用沉浸式主题不走这个方法
        super.onSizeChanged(w, h, oldw, oldh)
        uiHandler.post {
            if (oldh - h > SOFTKEYPAD_MIN_HEIGHT) {
                keyBordStateListener?.stateChange(KEYBORAD_SHOW)
            } else {
                if (keyBordStateListener != null) {
                    keyBordStateListener?.stateChange(KEYBORAD_HIDE)
                }
            }
        }
    }

    public fun setKeyBordStateListener(keyBordStateListener: KeyBordStateListener) {
        this.keyBordStateListener = keyBordStateListener;
    }

    interface KeyBordStateListener {
        fun stateChange(state: Int)
    }
}