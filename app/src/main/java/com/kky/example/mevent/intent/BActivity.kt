package com.kky.example.mevent.intent

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.kky.example.R
import com.kky.example.base.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_a.*

/**
 * Author: Zeus
 * Date: 2021/4/14 16:29
 * Description:
 * History:
 */
class BActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        button11.text = "i'm BActivity"
    }

    companion object {
        fun start(context: Context) {
            var intent = Intent(context, BActivity::class.java)
            context.startActivity(intent)
        }
    }
}