package com.kky.example.meffect.wheel

import android.content.Context
import android.graphics.*
import android.text.TextPaint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatSeekBar

/*
* @author Zeus
* create at 2019/4/13 11:41
* modify at 2019/4/13 11:41
* modify because 
* description: TO FIT
*/
class TextThumbSeekBar :
        AppCompatSeekBar {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, attributeSetId: Int) : super(context, attrs, attributeSetId)

    private val thumbSize = context.dpF(16f)
    private val textPaint: TextPaint = TextPaint().apply {
        color = Color.WHITE
        textSize = context.sp(14f)
        typeface = Typeface.DEFAULT
        textAlign = Paint.Align.CENTER
    }
    private var bounds = Rect()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val progressText = progress.toString()
        textPaint.getTextBounds(progressText, 0, progressText.length, bounds)

        val leftPadding = paddingLeft - thumbOffset
        val rightPadding = paddingRight - thumbOffset
        val width = width - leftPadding - rightPadding
        val progressRatio = progress.toFloat() / max
        val thumbOffset = thumbSize * (.5f - progressRatio)
        val thumbX = progressRatio * width + leftPadding.toFloat() + thumbOffset
        val thumbY = height / 2f + bounds.height() / 2f
        canvas.drawText(progressText, thumbX, thumbY, textPaint)
    }

    private fun Context.sp(sp: Float): Float = sp * resources.displayMetrics.scaledDensity
    private fun Context.dpF(dp: Float): Float = dp * resources.displayMetrics.density
}