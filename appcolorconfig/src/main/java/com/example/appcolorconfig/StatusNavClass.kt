package com.example.appcolorconfig

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_nav.*

/**
 * Author: Zeus
 * Date: 2021/4/7 11:49
 * Description: Nav
 * History:
 */
class StatusNavClass : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav)
        tv_center.text = "StatusBarNav"
    }
}