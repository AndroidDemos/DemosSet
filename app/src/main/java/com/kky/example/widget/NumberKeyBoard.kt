package com.kky.example.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import android.util.AttributeSet
import com.kky.example.R

/**
 * Author: Zeus
 * Date: 2020/7/17 15:44
 * Description: 输入数字键盘
 * History:
 */
public class NumberKeyBoard : KeyboardView, KeyboardView.OnKeyboardActionListener {

    private var TAG = "PwdKeyboardView";

    private var KEY_EMPTY = -10;

    private var delKeyBackgroundColor = 0xffcccccc;

    private var keyIconRect: Rect? = null

//    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    private fun init(context: Context) {
        var keyboard = Keyboard(context, R.xml.key_number)
        setKeyboard(keyboard)
        isEnabled = true
        isFocusable = true
        isPreviewEnabled = true
        onKeyboardActionListener = this
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var keys = getKeyboard().getKeys()
        for (key in keys) {
            if (key.codes[0] == KEY_EMPTY) {
                // 绘制空白键背景
                drawKeyBackground(key, canvas, delKeyBackgroundColor)
            }
            if (key.codes[0] == Keyboard.KEYCODE_DELETE) {
                // 删除删除按键背景
                drawKeyBackground(key, canvas, delKeyBackgroundColor)
                // 绘制删除按键图标
                drawKeyIcon(key, canvas, getResources().getDrawable(R.drawable.icon_soft_delete));
            }
        }
    }

    private fun drawKeyIcon(key: Keyboard.Key, canvas: Canvas, iconDrawable: Drawable?) {
        iconDrawable?.let {
            if (keyIconRect == null || keyIconRect!!.isEmpty) {// 计算按键icon 的rect 范围
                // 得到 keyicon 的显示大小，因为图片放在不同的drawable-dpi目录下，显示大小也不一样
                var intrinsicWidth = it.intrinsicWidth
                var intrinsicHeight = it.intrinsicHeight
                var drawWidth = intrinsicWidth
                var drawHeight = intrinsicHeight
                if (drawWidth > key.width) {
                    drawWidth = key.width
                    // 此时高就按照比例缩放
                    drawHeight = (drawWidth * 1.0f / intrinsicWidth * intrinsicHeight).toInt()
                } else if (drawHeight > key.height) {
                    drawHeight = key.height
                    drawWidth = (drawHeight * 1.0f / intrinsicHeight * intrinsicWidth).toInt()
                }
                // 获取图片的 x,y 坐标,图片在按键的正中间
                var left = key.x + key.width / 2 - drawWidth / 2
                var top = key.y + key.height / 2 - drawHeight / 2
                keyIconRect = Rect(left, top, left + drawWidth, top + drawHeight)
            }
            if (keyIconRect != null && !keyIconRect!!.isEmpty) {
                it.setBounds(keyIconRect);
                it.draw(canvas);
            }
        }
    }

    private fun drawKeyBackground(key: Keyboard.Key, canvas: Canvas, color: Long) {
        var drawable = ColorDrawable(color.toInt())
        drawable.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
        drawable.draw(canvas);


    }

    override fun onPress(primaryCode: Int) {
    }

    override fun onRelease(primaryCode: Int) {
    }

    override fun onKey(primaryCode: Int, keyCodes: IntArray?) {
    }

    override fun onText(text: CharSequence?) {
    }

    override fun swipeLeft() {
        super.swipeLeft()
    }

    override fun swipeUp() {
        super.swipeUp()
    }

    override fun swipeRight() {
        super.swipeRight()
    }

    override fun swipeDown() {
        super.swipeDown()
    }

}