package com.kky.example.widget.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.kky.example.bean.PieData

/*
* @author Zeus
* create at 2019/4/27 17:02
* modify at 2019/4/27 17:02
* modify because 
* description: 画布缩放
*/
class CanvasView1 : View {

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
        mPaint.style = Paint.Style.STROKE
        canvas.translate(mWidth/2,mHeight/2)
        var rect = RectF(0f,-400f,400f,0f)//矩形区域
        mPaint.color = Color.BLACK//绘制黑色矩形
        canvas.drawRect(rect,mPaint)

        canvas.scale(0.5f,0.5f)//画布缩放
        mPaint.color = Color.BLUE//绘制蓝色矩形
        canvas.drawRect(rect,mPaint)

    }


    // 初始化数据


}