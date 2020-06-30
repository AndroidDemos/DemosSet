package com.kky.example.mview

import android.os.Bundle
import android.widget.GridLayout
import android.widget.GridLayout.Spec
import android.widget.TextView
import com.kky.example.R
import com.kky.example.base.activity.BaseActivity
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
        gl_my.rowCount = 4
        for (gBean in listStr) {
            var tv = TextView(this)
            tv.text = gBean.name
            val rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
            val columnSpec: Spec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
//            val rowSpec = GridLayout.spec(gBean.row, 1, GridLayout.UNDEFINED.toFloat())
//            val columnSpec: Spec = GridLayout.spec(gBean.column, 1, GridLayout.UNDEFINED.toFloat())
            val params: GridLayout.LayoutParams = GridLayout.LayoutParams(rowSpec, columnSpec)
            gl_my.addView(tv, params)
        }
    }

    private fun initData() {
        for (o in 0..4) {
            for (i in 0..4) {
                listStr.add(GBean("$o--$i", 0 - 1, i))
            }
        }
    }
}

data class GBean(val name: String, val row: Int, val column: Int)