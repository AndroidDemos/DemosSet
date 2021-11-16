package com.kky.example.mui

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import com.kky.example.R
import com.kky.example.base.activity.BaseActivity
import com.kky.example.util.ShapeHelp
import kotlinx.android.synthetic.main.activity_shape.*

/**
 * Author: Zeus
 * Date: 2021/1/27 10:32
 * Description: 测试shape
 * History:
 */
class ShapeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shape)
        initListener()
    }

    private fun initListener() {

        val apply = GradientDrawable().apply {
            this.cornerRadius = 10f
            this.setStroke(20, Color.BLUE) // 指定边框
            this.gradientType = GradientDrawable.LINEAR_GRADIENT // 指定渲染角度
            this.orientation = GradientDrawable.Orientation.TOP_BOTTOM
            this.colors = intArrayOf(Color.RED, Color.TRANSPARENT) // 指定渐变色
        }
        tv1.background = apply
        tv2.background = ShapeHelp.getShapeGradient(GradientDrawable.LINEAR_GRADIENT, GradientDrawable.Orientation.TOP_BOTTOM, "#FFE8B0", "#FBD289", 12f)
        v_shape_in_code.background = ShapeHelp.getShapeGradient(GradientDrawable.LINEAR_GRADIENT, GradientDrawable.Orientation.TOP_BOTTOM, "#5097FB", "#FFFFFF", 0f)
        v_shape_in_code.visibility = View.GONE
    }
}