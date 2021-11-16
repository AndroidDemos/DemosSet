package com.kky.example.util

import android.graphics.Color
import android.graphics.drawable.GradientDrawable

/**
 * Author: Zeus
 * Date: 2021/1/27 10:51
 * Description: 避免写过多shape文件
 * History:
 */
object ShapeHelp {
    fun getShapeGradient(gradientType: Int, gradientOrientation: GradientDrawable.Orientation, startColor: String, endColor: String, radius: Float? = null): GradientDrawable {
        val drawable = GradientDrawable().apply {
            if (radius != null && radius > 0) {
                this.cornerRadius = radius
            }
            this.gradientType = gradientType // 指定渲染角度
            this.orientation = gradientOrientation
            this.colors = intArrayOf(Color.parseColor(startColor), Color.parseColor(startColor), Color.parseColor(endColor)) // 指定渐变色
        }
        return drawable
    }

    fun getShapeWidthStroke(): GradientDrawable {
        val drawable = GradientDrawable().apply {
            this.cornerRadius = 10f
            this.setStroke(20, Color.BLUE) // 指定边框
            this.gradientType = GradientDrawable.LINEAR_GRADIENT // 指定渲染角度
            this.orientation = GradientDrawable.Orientation.TOP_BOTTOM
            this.colors = intArrayOf(Color.RED, Color.TRANSPARENT) // 指定渐变色
        }
        return drawable
    }
}