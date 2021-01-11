package com.kky.example.mview

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.kky.example.R
import com.kky.example.base.activity.BaseActivity
import com.kky.example.util.ToastUtils
import kotlinx.android.synthetic.main.activity_key_board.*

/**
 * Author: Zeus
 * Date: 2020/7/17 15:16
 * Description: 自定义键盘
 * History:
 */
class KeyBoardActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_key_board)
        et_code.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
        et_code.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                my_keyboard.visibility = View.VISIBLE
            } else {
                my_keyboard.visibility = View.GONE
            }
        }
        tv_complete.setOnClickListener {
            ToastUtils.makeText("hide ")
//            et_code.clearFocus()
//            my_keyboard.visibility = View.GONE
            hideKeyBoard()
        }
    }

    public fun hideKeyBoard() {
        var imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (imm != null) {
            imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(),
                    0);
        }
    }

}