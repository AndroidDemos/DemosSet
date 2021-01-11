package com.example.appcolorconfig

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        EditTextUtil.setDoubleText(et_personal, 4, 2)
//        et_personal.filters = arrayOf<InputFilter>(PointInputFilter())
        var sss = "0012.12321"
        val toDouble = sss.toDouble()
        EditTextUtil.printLoge("ss-value-$toDouble")
        et_personal.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                s?.let {
                    if (s.startsWith(".")) {
                        if (s.length > 1) {
                            s.delete(0, 1)
                        }
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
//        AndroidBug5497WorkaroundOld.assistActivity(this)
        AndroidBug5497WorkaroundFixed.assistActivity(this)
//        AndroidWorkaround.assistActivity(this)
//        ScrollHideHelp.addScrollListener(this, object : ScrollHideHelp.ScrollViewListener {
//            override fun onShow(state: Int) {
//                EditTextUtil.printLoge("state--$state")
//                if (state == 0) {
//                    scroll_container.scrollTo(0, tv_to_show.top)
//                } else {
//
//                }
//            }
//        })
    }
}