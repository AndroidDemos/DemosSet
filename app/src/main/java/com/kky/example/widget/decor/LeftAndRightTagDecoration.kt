package com.kky.example.widget.decor

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.kky.example.R


/**
 * 正常的分割线
 */
class LeftAndRightTagDecoration : RecyclerView.ItemDecoration {//分割线是通过父控件的背景色实现

    private var tagWidth = 0
    private var leftPaint: Paint = Paint()
    private var rightPaint: Paint

    constructor(context: Context) {
        leftPaint.color = ContextCompat.getColor(context, R.color.colorAccent)
        rightPaint = Paint()
        rightPaint.color = ContextCompat.getColor(context, R.color.colorPrimary)
        tagWidth = context.resources.getDimensionPixelSize(R.dimen.activity_horizontal_margin)
    }


    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val pos = parent.getChildAdapterPosition(child)
            val isLeft = pos % 2 == 0
            if (isLeft) {
                val left = child.left.toFloat()
                val right = left + tagWidth
                val top = child.top.toFloat()
                val bottom = child.bottom.toFloat()
                c.drawRect(left, top, right, bottom, leftPaint)
            } else {
                val right = child.right.toFloat()
                val left = right - tagWidth
                val top = child.top.toFloat()
                val bottom = child.bottom.toFloat()
                c.drawRect(left, top, right, bottom, rightPaint)
            }
        }
    }
}