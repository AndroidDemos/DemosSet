package com.kky.example.widget.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/*
* @author Zeus
* create at 2019/4/28 11:09
* modify at 2019/4/28 11:09
* modify because 
* description: TO FIT
*/
class CircleView : View {
    private var mPaint = Paint()
    private var mWidth: Float = 0f
    private var mHeight: Float = 0f

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        mPaint.style = Paint.Style.FILL
        mPaint.isAntiAlias = true
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w.toFloat()
        mHeight = h.toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        mPaint.color = Color.RED
        mPaint.style = Paint.Style.STROKE
        canvas.translate(mWidth / 2, mHeight / 2)
        canvas.drawCircle(0f, 0f, 200f, mPaint)
        canvas.drawCircle(0f, 0f, 180f, mPaint)
        for (i in 0..10) {
            canvas.drawLine(0f, 180f, 0f, 200f, mPaint)
            canvas.rotate(36f)
        }
    }
}