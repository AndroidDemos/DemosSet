package com.kky.example.mview

import android.os.Bundle
import android.view.WindowManager
import android.widget.RadioGroup
import com.kky.example.R
import com.kky.example.base.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_soft_input1.*

//不设置软键盘弹出模式的情况下  默认是SOFT_INPUT_ADJUST_RESIZE模式
class SoftInputActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soft_input1)
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
    }
}