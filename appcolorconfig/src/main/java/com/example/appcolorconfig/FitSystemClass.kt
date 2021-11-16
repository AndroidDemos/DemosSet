package com.example.appcolorconfig

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_nav.*

/**
 * Author: Zeus
 * Date: 2021/4/7 11:49
 * Description: Nav
 * History:
 */
class FitSystemClass : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav)
        tv_center.text = "FitSystemNav"
        var view = getWindow().getDecorView().findViewById<ViewGroup>(android.R.id.content)
        view.fitsSystemWindows = true
    }
}