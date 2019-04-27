package com.kky.example.meffect.wheel

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.kky.example.R
import kotlinx.android.synthetic.main.activity_wheel_view.*
import kotlinx.android.synthetic.main.bottomsheet_settings_attributes.*
import ru.github.igla.ferriswheel.CabinStyle
import ru.github.igla.ferriswheel.FerrisWheelView

/*
* @author Zeus
* create at 2019/4/2 14:41
* modify at 2019/4/2 14:41
* modify because 
* description: TO FIT
*/
class WheelViewActivity :AppCompatActivity(){
    private lateinit var behavior: BottomSheetBehavior<View>

    private val clickCenterListener = object : FerrisWheelView.OnClickCenterListener {
        override fun onClickCenter(e: MotionEvent) {
            Toast.makeText(this@WheelViewActivity, "Click center $e", Toast.LENGTH_LONG).show()
        }
    }
    private val clickCabinListener = object : FerrisWheelView.OnClickCabinListener {
        override fun onClickCabin(cabinNumber: Int, e: MotionEvent) {
            Toast.makeText(this@WheelViewActivity, "Click cabin $cabinNumber", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wheel_view)
        initSettingsBottomSheet()
        ferrisWheelView.apply {
            centerListener = this@WheelViewActivity.clickCenterListener
            cabinListener = this@WheelViewActivity.clickCabinListener
            cabinColors = arrayOf("#6eabdf", "#ffb140", "#ce4d5b", "#96bd58", "#ed7a50").map { color ->
                CabinStyle(Color.parseColor(color), Color.BLACK)
            }
        }
        tvAction.setOnClickListener {
            startActivity(Intent(this, WheelViewActivity::class.java))
        }

        startCircle.setOnClickListener {
            ferrisWheelView.startAnimation()
        }
        stopCircle.setOnClickListener {
            ferrisWheelView.stopAnimation()
        }
        pauseCircle.setOnClickListener {
            ferrisWheelView.pauseAnimation()
        }
        resumeCircle.setOnClickListener {
            ferrisWheelView.resumeAnimation()
        }
    }

    private fun initSettingsBottomSheet() {

        behavior = BottomSheetBehavior.from<View>(bottomSheet).apply {
            setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onStateChanged(@NonNull bottomSheet: View, newState: Int) {
                    val res = when (newState) {
                        BottomSheetBehavior.STATE_EXPANDED -> R.drawable.ic_expand_more_black_24dp
                        else -> R.drawable.ic_expand_less_black_24dp
                    }
                    image_toggle.setImageResource(res)
                }

                override fun onSlide(@NonNull bottomSheet: View, slideOffset: Float) {
                }
            })
        }
        view_options_header.setOnClickListener {
            behavior.state = if (behavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
                BottomSheetBehavior.STATE_EXPANDED
            } else {
                BottomSheetBehavior.STATE_COLLAPSED
            }
        }
    }
}