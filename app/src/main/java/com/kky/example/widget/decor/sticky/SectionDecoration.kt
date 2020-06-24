package com.kky.example.widget.decor.sticky

import android.content.Context
import android.graphics.*
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.kky.example.R
import com.kky.example.mview.sticky.DecorationCallback

/**
 * 正常的分割线
 */
class SectionDecoration : RecyclerView.ItemDecoration {//分割线是通过父控件的背景色实现

    private var callback: DecorationCallback
    private var textPaint: Paint
    private var paint: Paint = Paint()
    private var topGap: Int
    private var fontMetrics: Paint.FontMetrics

    constructor(context: Context, decorationCallback: DecorationCallback) {
        paint.color = ContextCompat.getColor(context, R.color.colorAccent)

        callback = decorationCallback
        //PinnedSectionDecoration
        textPaint = Paint()
        textPaint.typeface = Typeface.DEFAULT_BOLD
        textPaint.isAntiAlias = true
        textPaint.textSize = 80f
        textPaint.color = Color.BLACK
        fontMetrics = Paint.FontMetrics()
        textPaint.getFontMetrics(fontMetrics)
        textPaint.textAlign = Paint.Align.LEFT
        topGap = context.resources.getDimensionPixelSize(R.dimen.dp_32)
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        var pos = parent.getChildAdapterPosition(view)
        var groupId = callback.getGroupId(pos)
        if (groupId < 0) return
        if (pos == 0 || isFirstInGroup(pos)) {//同组的第一个才添加padding
            outRect.top = topGap
        } else {
            outRect.top = 0
        }
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        var left = parent.paddingLeft
        val right = parent.width - parent.paddingRight
        var childCount = parent.childCount
        for (i in 0 until childCount) {
            val view = parent.getChildAt(i)
            val position = parent.getChildAdapterPosition(view)
            val groupId = callback.getGroupId(position)
            if (groupId < 0) return
            val textLine = callback.getGroupFirstLine(position).toUpperCase()
            if (position == 0 || isFirstInGroup(position)) {
                val top = view.top - topGap.toFloat()
                val bottom = view.top.toFloat()
                c.drawRect(left.toFloat(), top, right.toFloat(), bottom, paint) //绘制红色矩形
                c.drawText(textLine, left.toFloat(), bottom, textPaint) //绘制文本
            }
        }
    }

    private fun isFirstInGroup(pos: Int): Boolean {
        return if (pos == 0) {
            true
        } else {
            val prevGroupId = callback.getGroupId(pos - 1)
            val groupId = callback.getGroupId(pos)
            prevGroupId != groupId
        }
    }
}