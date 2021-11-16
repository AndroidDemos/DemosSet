package com.kky.example.mevent.intent

import android.app.Activity
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
class AActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        button11.setOnClickListener {
            BActivity.start(this)
            var intent = Intent()
            intent.putExtra("data", "1203192381")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    companion object {
        fun start(context: Context, code: Int) {
            var intent = Intent(context, AActivity::class.java)
            if (context is Activity) {
                context.startActivityForResult(intent, code)
            }
        }
    }
}