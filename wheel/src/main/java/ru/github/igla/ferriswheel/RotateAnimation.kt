package ru.github.igla.ferriswheel

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.view.animation.LinearInterpolator

/*
* @author Zeus
* create at 2019/4/13 10:16
* modify at 2019/4/13 10:16
* modify because 
* description: TO FIT
*/
internal class RotateAnimation (private val viewConfig: WheelViewConfig){
    interface OnRotateAngleValueChangeListener{
        fun onChangeRotateAngle(angle:Float)
    }

    private var lastChangeAngle:Float = viewConfig.startAngle

    private var animator:ValueAnimator? = null

    private var animInterpolator = LinearInterpolator()

    var isRunning = animator?.isRunning?:false
    private set


    fun startAnimation(listener: OnAngleChangeListener){
        stopAnimation()
        val rotateSpeed = viewConfig.rotateSpeed
        if(rotateSpeed>0){
            animator = createAnimator(listener,
                    rotateSpeed,
                    viewConfig.getAngleFrom,
                    viewConfig.getAngleTo).apply {
                start() }
        }
    }

    private fun createAnimator(listener: OnAngleChangeListener, rotateSpeed: Int, angleFrom: Float, angleTo: Float): ObjectAnimator {

        val property = FloatProperty.createAngleProperty(object :OnAngleChangeListener{
            override fun onValueChange(angle: Float) {
                lastChangeAngle = angle
                listener.onValueChange(angle)
            }
        })
        return ObjectAnimator.ofFloat(listener,property,angleFrom,angleTo).apply {
            currentPlayTime = viewConfig.getDurationOffset(lastChangeAngle)
            duration = getDurationFromSpeed(rotateSpeed)
            interpolator = animInterpolator
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.RESTART
        }
    }

     fun stopAnimation() {
        animator?.let {
            it.removeAllListeners()
            it.cancel()
            this.lastChangeAngle = 0f
        }
    }


    fun pauseAnimation() {
        animator?.let {
            if (it.isRunning) {
                it.cancel()
            }
        }
    }

    fun resumeAnimation() {
        animator?.apply {
            if (!isRunning) {
                duration = getDurationFromSpeed(viewConfig.rotateSpeed)
                currentPlayTime = viewConfig.getDurationOffset(lastChangeAngle)
                start()
            }
        }
    }


}