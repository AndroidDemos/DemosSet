package com.kky.example.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

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
    }
}