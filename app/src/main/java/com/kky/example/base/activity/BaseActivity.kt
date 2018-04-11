package com.kky.example.base.activity

import android.app.Activity
import android.os.Bundle

/**
 * @name DemosSet
 * @author Zeus QQ:1946690608
 * @time 2018/4/8 19:58
 * @change time
 * @class describe
 */
open class BaseActivity : Activity() {
    protected open var TAG: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TAG = this.javaClass.simpleName
    }
}