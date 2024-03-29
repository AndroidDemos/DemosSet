package com.kky.example.mui

import android.os.Bundle
import com.kky.example.R
import com.kky.example.base.activity.BaseActivity
import com.kky.example.util.LocalPrinter

/**
 * Author: Zeus
 * Date: 2020/7/30 10:26
 * Description: 全面屏遮挡
 * History:
 */
public class FullScreenActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen)
        var time = "1.921.20211103"
        LocalPrinter.printLocal("index--" + time.substring(0,time.lastIndexOf(".")))
    }
}