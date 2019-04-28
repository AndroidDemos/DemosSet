package ru.github.igla.ferriswheel

import android.view.GestureDetector
import android.view.MotionEvent

/*
* @author Zeus
* create at 2019/4/13 10:05
* modify at 2019/4/13 10:05
* modify because 
* description: TO FIT
*/
class InteractGestureListener (
        private val clickCenter:(MotionEvent) ->Boolean):GestureDetector.SimpleOnGestureListener(){
    override fun onSingleTapUp(e: MotionEvent): Boolean =true

    override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
        if(clickCenter(e)){
            return true
        }
        return super.onSingleTapConfirmed(e)
    }

}
