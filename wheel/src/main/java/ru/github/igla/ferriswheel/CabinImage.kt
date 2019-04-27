package ru.github.igla.ferriswheel

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.graphics.RectF

/*
* @author Zeus
* create at 2019/4/8 10:51
* modify at 2019/4/8 10:51
* modify because 
* description: TO FIT
*/
internal class CabinImage(context: Context, val imageNumber: Int, private val startAngle: Double, colorStyle: CabinStyle) {
    val wheelPos: PointF = PointF()
    var tiltAngle = 0f
    private val dstRectF = RectF()
    private val bottomLineOffset = context.dpF(14f)
    private val cabinLineHeight = context.dpF(8f)
    private val cabinWindowHeight = context.dpF(24f)
    private val cabinStrokeWidth = context.dpF(6f)
    private val cabinCornerRadius = context.dpF(8f)
    private val arcRadius = context.dpF(8f)

    private var cabinLinePaint: Paint = smoothPaint(colorStyle.colorLineStroke).apply {
        style = Paint.Style.FILL
    }

    private lateinit var cabinPaint: Paint
    private lateinit var cabinPaintFill: Paint

    init {
        colorStyle.colorFill.apply {
            cabinPaint = smoothPaint(this).apply {
                strokeWidth = cabinStrokeWidth
                style = Paint.Style.STROKE
            }
            cabinPaintFill = smoothPaint(this).apply {
                style = Paint.Style.FILL
            }
        }
    }

    //
    internal fun getAngleOffset(rotateAngle: Float): Double = (startAngle + rotateAngle) % 360.0

    //
    internal fun drawCabin(canvas: Canvas, position: PointF, size: Int, scale: Float) {
        canvas.apply {
            save()
            val arcRadiusScale = arcRadius * scale
            val cabinWindowHeightScale = cabinWindowHeight * scale
            val cabinCornerRadiusScale = cabinCornerRadius * scale
            val cabinStrokeWidthScale = cabinStrokeWidth * scale

            val angle = if (imageNumber % 2 == 0) tiltAngle else -tiltAngle

            rotate(angle, position.x, position.y)

            val halfSize = size / 2.0f
            val leftBorder = position.x - halfSize
            val topBorder = position.y
            val rightBorder = position.x + halfSize
            val bottomBorder = position.y + size

            val cabinStrokeHalf = cabinStrokeWidthScale / 2f
            val cabinTop = topBorder + cabinStrokeHalf
            val cabinBottom = topBorder - cabinStrokeHalf
            dstRectF.set(
                    leftBorder + cabinStrokeHalf,
                    cabinTop,
                    rightBorder - cabinStrokeHalf,
                    cabinBottom)
            drawRoundRect(dstRectF, cabinCornerRadiusScale, cabinCornerRadiusScale, cabinPaint)//cabin

            val centerArc = leftBorder + halfSize
            dstRectF.set(centerArc - arcRadiusScale * 0.8f,
                    cabinTop - arcRadiusScale,
                    centerArc + arcRadiusScale * 0.8f,
                    topBorder + arcRadiusScale)
            drawArc(dstRectF, 180f, 180f, true, cabinPaintFill)//top Arc

            dstRectF.set(leftBorder + cabinStrokeHalf,
                    cabinTop,
                    rightBorder - cabinStrokeHalf,
                    cabinBottom)
            draBwBottomRoundRect(canvas, dstRectF, cabinPaintFill, cabinCornerRadiusScale)//cabin fill

            val blackLineTop = bottomBorder - (bottomLineOffset + cabinLineHeight) * scale
            val blackLineBottom = bottomBorder - bottomLineOffset * scale
            drawRect(leftBorder, blackLineTop, rightBorder, blackLineBottom,
                    cabinLinePaint)//画线
            restore()
        }
    }

    private fun draBwBottomRoundRect(canvas: Canvas, rect: RectF, paint: Paint, radius: Float) {
        canvas.drawRoundRect(rect, radius, radius, paint)
        canvas.drawRect(
                rect.left,
                rect.top,
                rect.right,
                rect.bottom - radius,
                paint
        )
    }

}