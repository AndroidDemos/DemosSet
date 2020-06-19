package com.kky.example.widget.decor

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.kky.example.R

/**
 * 正常的分割线
 */
class SimpleDividerDecoration : RecyclerView.ItemDecoration {//分割线是通过父控件的背景色实现

    private var dividerHeight = 0
    private var horziontalPadding = 0
    private var dividerPaint: Paint

    constructor(context: Context) {
        dividerHeight = context.resources.getDimensionPixelSize(R.dimen.divider_height)
        horziontalPadding = context.resources.getDimensionPixelSize(R.dimen.activity_horizontal_margin)
        dividerPaint = Paint()
        dividerPaint.color = ContextCompat.getColor(context, R.color.red)
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = dividerHeight
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
//        super.onDraw(c, parent, state)
        var childCount = parent.childCount
        var left = parent.paddingLeft + horziontalPadding
        var right = parent.width - parent.paddingRight - horziontalPadding
        for (i in 0..(childCount - 2)) {
            val view = parent.getChildAt(i)
            val top = view.bottom.toFloat()
            val bottom = view.bottom + dividerHeight.toFloat()
            c.drawRect(left.toFloat(), top, right.toFloat(), bottom, dividerPaint)
        }
    }
}