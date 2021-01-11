package com.kky.example.widget.decor

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kky.example.R

class PaddingItemDerocation : RecyclerView.ItemDecoration {//分割线是通过父控件的背景色实现

    private var dividerHeight = 1

    constructor(context: Context) {
        dividerHeight = context.resources.getDimensionPixelSize(R.dimen.divider_height)
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        if (position % 4 == 0) {
            outRect.bottom = dividerHeight
        }
    }
}