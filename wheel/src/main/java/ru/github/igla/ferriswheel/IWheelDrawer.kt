package ru.github.igla.ferriswheel

import android.graphics.Canvas
import android.graphics.Rect

/*
* @author Zeus
* create at 2019/4/13 10:11
* modify at 2019/4/13 10:11
* modify because 
* description: TO FIT
*/
interface IWheelDrawer {
    fun onPreDraw(canvas: Canvas)
    fun onPostDraw(canvas: Canvas)
    fun configure(rect: Rect)
}