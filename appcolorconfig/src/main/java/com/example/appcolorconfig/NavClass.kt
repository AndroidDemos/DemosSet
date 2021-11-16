package com.example.appcolorconfig

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.Log
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_nav.*

/**
 * Author: Zeus
 * Date: 2021/4/7 11:49
 * Description: Nav
 * History:
 */
class NavClass : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav)
        try {
            var dString = "102.22"
            var toDouble = dString.toDouble().toInt()
            Log.e("nav---tag", "nav==int value--$toDouble")
        } catch (e: Exception) {
        }


        try {
            val d = 12.02
            val i = d.toInt()
            Log.e("nav---tag", "nav==int iii--$i")
        } catch (e: Exception) {
        }
        et_personal.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
        et_personal.setText("4356234924@qq.com")
        hideSoftKeyboard(this)
    }

    fun hideSoftKeyboard(activity: Activity) {
        val view = activity.currentFocus
        if (view != null) {
            val inputMethodManager = activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }


}