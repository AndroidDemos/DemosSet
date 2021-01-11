package com.kky.example.mui

import android.os.Bundle
import com.kky.example.R
import com.kky.example.base.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_basic.*

/**
 * Author: Zeus
 * Date: 2020/7/6 17:16
 * Description:
 * History:
 */
class BasicActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)
        button.setOnClickListener {
            textView.text = "hello ,i'm first"
        }
    }
}