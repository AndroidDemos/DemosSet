package com.kky.example.widget.decor.sticky

import android.content.Context
import android.graphics.*
import android.text.TextUtils
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.kky.example.R
import com.kky.example.mview.sticky.DecorationCallback


/**
 * 正常的分割线
 */
class PinnedSectionDecoration : RecyclerView.ItemDecoration {//分割线是通过父控件的背景色实现

    private var callback: DecorationCallback
    private var textPaint: Paint
    private var paint: Paint = Paint()
    private var topGap: Int
    private var fontMetrics: Paint.FontMetrics

    constructor(context: Context, decorationCallback: DecorationCallback) {
        paint.color = ContextCompat.getColor(context, R.color.colorAccent)

        callback = decorationCallback
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

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        val itemCount = state.itemCount
        val childCount = parent.childCount
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight
        val lineHeight = textPaint.textSize + fontMetrics.descent

        var preGroupId: Long
        var groupId: Long = -1

        for (i in 0 until childCount) {
            val view = parent.getChildAt(i)
            val position = parent.getChildAdapterPosition(view)
            preGroupId = groupId
            groupId = callback.getGroupId(position)

            if (groupId < 0 || groupId == preGroupId) continue
            var textLine = callback.getGroupFirstLine(position).toUpperCase()
            if (TextUtils.isEmpty(textLine)) continue

            var viewBottom = view.bottom
            var textY = topGap.coerceAtLeast(view.top)
            if (position + 1 < itemCount) {
                var nextGroupId = callback.getGroupId(position + 1)
                if (nextGroupId != groupId && viewBottom < textY) {//组内最后一个view进入了header
                    textY = viewBottom
                }
            }
            c.drawRect(left.toFloat(), (textY - topGap).toFloat(), right.toFloat(), textY.toFloat(), paint)
            c.drawText(textLine, left.toFloat(), textY.toFloat(), textPaint)
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