package com.example.appcolorconfig

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_entrance.*

/**
 * Author: Zeus
 * Date: 2021/4/7 11:43
 * Description: 入口
 * History:
 */
class EntranceActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrance)
        button_nav.setOnClickListener {
            var intent = Intent(this, NavClass::class.java)
            startActivity(intent)
        }
        button_status.setOnClickListener {
            var intent = Intent(this, StatusBarClass::class.java)
            startActivity(intent)
        }
        button_status_nav.setOnClickListener {
            var intent = Intent(this, StatusNavClass::class.java)
            startActivity(intent)
        }
        button_fit_system.setOnClickListener {
            var intent = Intent(this, FitSystemClass::class.java)
            startActivity(intent)
        }
        button_to_main.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}