package com.kky.example.mview

import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import com.kky.example.R
import com.kky.example.base.activity.BaseActivity
import com.kky.example.util.LocalPrinter
import com.kky.example.util.ToastUtils
import kotlinx.android.synthetic.main.activity_scroll_input.*

/**
 * Author: Zeus
 * Date: 2021/5/19 17:23
 * Description:
 * History:
 */
public class ScrollInputActivity : BaseActivity() {
    private var gestureDetector: GestureDetector? = null
    private var mRootView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRootView = window.decorView
        setContentView(R.layout.activity_scroll_input)
        btn_shrink.setOnClickListener {
            ToastUtils.makeText("i'm shrink now")
        }

        sv_container.setTapListener {
            ToastUtils.makeText("i'm sv shrink now")
        }
        bt_in_container.setOnClickListener {
            ToastUtils.makeText("i'm in container shrink now")
        }
    }

    private fun initGestureListener() {
        gestureDetector = GestureDetector(this, GestureListener())
        gestureDetector = GestureDetector( GestureListener())
    }


    private fun initListener() {
        gestureDetector = GestureDetector(this, object : GestureDetector.OnGestureListener {
            override fun onShowPress(e: MotionEvent?) {
                LocalPrinter.printLocal("onShowPress")
            }

            override fun onSingleTapUp(e: MotionEvent?): Boolean {
                LocalPrinter.printLocal("onSingleTapUp")
                return false
            }

            override fun onDown(e: MotionEvent): Boolean {
                LocalPrinter.printLocal("onDown--e-x:${e.x}--e-y:${e.y}")
                return false
            }

            override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
                LocalPrinter.printLocal("onFling")
                return false
            }

            override fun onScroll(e1: MotionEvent, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
                val pos = e2!!.x

                LocalPrinter.printLocal("onScroll--e1-x:${e1.x}--e1-y:${e1.y}")
                LocalPrinter.printLocal("onScroll--e2-x:${e2.x}--e2-y:${e2.y}")
                LocalPrinter.printLocal("onScroll--d2-x:${distanceX}--d2-y:${distanceY}")

                return false
            }

            override fun onLongPress(e: MotionEvent?) {
                LocalPrinter.printLocal("onLongPress")
            }
        })

    }

    private class GestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onScroll(e1: MotionEvent, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
            if (e1 != null) {
//                handlerCurrentActivityScroll(e2)
                LocalPrinter.printLocal("onScroll-in-GestureListener--e1-x:${e1.x}--e1-y:${e1.y}")

            }
            return super.onScroll(e1, e2, distanceX, distanceY)
        }

        /**
         * 处理当前页面滑动
         */
        private fun handlerCurrentActivityScroll(e2: MotionEvent) {
//            mRootView.setTranslationX(e2.x)

        }
    }

}