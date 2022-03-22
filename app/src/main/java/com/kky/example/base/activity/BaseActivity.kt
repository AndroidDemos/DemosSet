package com.kky.example.base.activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.kky.example.util.LocalPrinter

/**
 * @name DemosSet
 * @author Zeus QQ:1946690608
 * @time 2018/4/8 19:58
 * @change time
 * @class describe
 */
open class BaseActivity : AppCompatActivity() {

    protected open var TAG: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TAG = this.javaClass.simpleName
        LocalPrinter.printLocal("$TAG   onCreate")

    }


    override fun onDestroy() {
        super.onDestroy()
        LocalPrinter.printLocal("$TAG   onDestroy")
    }

    override fun onStop() {
        super.onStop()
        LocalPrinter.printLocal("$TAG   onStop")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        LocalPrinter.printLocal("$TAG   onNewIntent")
    }
}