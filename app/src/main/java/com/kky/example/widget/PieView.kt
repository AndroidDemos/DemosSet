package com.kky.example.widget

import android.content.Context
import android.graphics.Canvas
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
* description: 柱状图
*/
class PieView : View {

    // 颜色表(注意: 此处定义颜色使用的是ARGB，带Alpha通道的)
    private var mColors = intArrayOf(-0x330100, -0x9b6a13, -0x1cd9ca, -0x800000, -0x7f8000, -0x7397, -0x7f7f80, -0x194800, -0x830400)
    // 饼状图初始绘制角度
    private var mStartAngle = 0f
    private var mPaint: Paint = Paint()
    private var mWidth: Int = 0
    private var mHeight: Int = 0
    private var mData: ArrayList<PieData>? = null

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        mPaint.style = Paint.Style.FILL
        mPaint.isAntiAlias = true
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w
        mHeight = h
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (null == mData) return
        var currentStartAngle = mStartAngle//当前起始角度
        canvas.translate((mWidth / 2).toFloat(), (mHeight / 2).toFloat())//将画布坐标原点移动到中心位置
        var r = Math.min(mWidth, mHeight) / 2 * 0.8.toFloat()
        var rect = RectF(-r, -r, r, r)
        mData?.let {
            if (it.size > 0) {
                for (pie in it!!) {
                    mPaint.color = pie.color
                    canvas.drawArc(rect, currentStartAngle, pie.angle, true, mPaint)
                    currentStartAngle += pie.angle
                }
            }
        }
    }

    // 初始化数据
    private fun initData(mData: ArrayList<PieData>?) {
        if (null == mData || mData.size === 0)
        // 数据有问题 直接返回
            return

        var sumValue = 0f
        for (i in 0 until mData.size) {
            val pie = mData[i]

            sumValue += pie.value       //计算数值和

            val j = i % mColors.size       //设置颜色
            pie.color = mColors[j]
        }

        var sumAngle = 0f
        for (i in 0 until mData.size) {
            val pie = mData[i]

            val percentage = pie.value / sumValue   // 百分比
            val angle = percentage * 360                 // 对应的角度

            pie.percentage = percentage                  // 记录百分比
            pie.angle = angle                            // 记录角度大小
            sumAngle += angle

            Log.i("angle", "" + pie.angle)
        }
    }

    // 设置起始角度
    fun setStartAngle(mStartAngle: Float) {
        this.mStartAngle = mStartAngle
        invalidate()   // 刷新
    }

    // 设置数据
    fun setData(mData: ArrayList<PieData>) {
        this.mData = mData
        initData(mData)
        invalidate()   // 刷新
    }
}