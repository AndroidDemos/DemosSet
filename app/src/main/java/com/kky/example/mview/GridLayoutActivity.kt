package com.kky.example.mview

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.kky.example.R
import com.kky.example.base.activity.BaseActivity
import com.kky.example.util.ScreenUtils
import kotlinx.android.synthetic.main.activity_grid_layout.*

/**
 * Author: Zeus
 * Date: 2020/6/30 17:53
 * Description:测试GridLayout功能
 * History:
 */
class GridLayoutActivity : BaseActivity() {
    var listStr = mutableListOf<GBean>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_layout)
        initData()
        setGridContent()
    }

    private fun setGridContent() {
        gl_my.rowCount = 10
        gl_my.columnCount = 5
        var width = ((ScreenUtils.getScreenWidth(this) - 120) / 5)
//        var height = 80
        if (gl_my.childCount > 0) {
            gl_my.removeAllViews()
        }
        for (gBean in listStr) {
            var view = LayoutInflater.from(this).inflate(R.layout.item_grid1, null, false)
            var viewParams = ViewGroup.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT)
//            view.layoutParams = viewParams
            var tv = view.findViewById<TextView>(R.id.tv_name)
            var tvSub = view.findViewById<TextView>(R.id.tv_sub)
//            tv.gravity = Gravity.CENTER
            tv.text = gBean.name
            tvSub.text = gBean.subName + "sxx-sxx-sxx-sxx-sxx-sxx-sxx-sxx-sxx-sxx-sxx-sxx-sxx-sxx-"
            tv.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent))
            var rowSpec: GridLayout.Spec
            if (gBean.row == 1) {
                rowSpec = GridLayout.spec(gBean.row, 1f)
            } else {
                rowSpec = GridLayout.spec(gBean.row, 1f)
            }
            var columnSpec: GridLayout.Spec
            if (gBean.column == 1) {
                columnSpec = GridLayout.spec(gBean.column, 1f)
            } else {
                columnSpec = GridLayout.spec(gBean.column, 1f)
            }
            var params: GridLayout.LayoutParams = GridLayout.LayoutParams(rowSpec, columnSpec)
            params.width = width
            when (gBean.column) {
                0 -> {
                    params.setGravity(Gravity.CENTER)
                }
                4 -> {
                    params.setGravity(Gravity.CENTER)
                }
                else -> {
                    params.setGravity(Gravity.CENTER)
                }
            }
            params.topMargin = 20
            if (gBean.row == 9) {
                params.bottomMargin = 20
            }
            params.leftMargin = 20
            if (gBean.column == 4) {
                params.rightMargin = 20
            }
            gl_my.addView(view, params)
        }
    }

    private fun initData() {
        for (row in 0..9) {
            for (column in 0..4) {
                listStr.add(GBean("$row--", "$column--", row, column))
            }
        }
    }
}

data class GBean(val name: String, val subName: String, val row: Int, val column: Int)