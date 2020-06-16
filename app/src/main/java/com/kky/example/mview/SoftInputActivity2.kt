package com.kky.example.mview

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.RadioGroup
import com.kky.example.R
import com.kky.example.base.activity.BaseActivity
import com.kky.example.widget.layout.ResizeLayout
import kotlinx.android.synthetic.main.activity_soft_input2.*


//不设置软键盘弹出模式的情况下  默认是SOFT_INPUT_ADJUST_RESIZE模式
//沉浸式模式
class SoftInputActivity2 : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soft_input2)
        var disAll = 1
        ll_back.setOnClickListener { this.finish() }
        rg_model.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup, checkedId: Int) {
                when (checkedId) {
                    R.id.rb_1 -> {
                        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE or WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)//压缩可压缩的空间
                    }
                    R.id.rb_2 -> {
                        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN or WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)//整个屏幕往上推移
                    }
                    R.id.rb_3 -> {
                        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING or WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)//屏幕控件不做任何调整
                    }
                    R.id.rb_4 -> {
                        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_UNSPECIFIED or WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)//根据之前设置的模式，即上一次设置了哪个模式。这次就继续沿用哪个模式
                    }
                }
            }

        })

        ll_root.setKeyBordStateListener(object : ResizeLayout.KeyBordStateListener {
            override fun stateChange(state: Int) {
                when (state) {
                    ResizeLayout.KEYBORAD_SHOW -> {
                        tv_desc1.visibility = View.GONE
                        tv_desc2.visibility = View.GONE
                        tv_desc3.visibility = View.GONE
                    }
                    ResizeLayout.KEYBORAD_HIDE -> {
                        tv_desc1.visibility = View.VISIBLE
                        tv_desc2.visibility = View.VISIBLE
                        tv_desc3.visibility = View.VISIBLE
                    }
                    else -> {
                        tv_desc1.visibility = View.VISIBLE
                        tv_desc2.visibility = View.VISIBLE
                        tv_desc3.visibility = View.VISIBLE
                    }
                }
            }
        })
    }
}