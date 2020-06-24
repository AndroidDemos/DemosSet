package com.kky.example.mview

import android.os.Bundle
import android.util.TypedValue
import com.kky.example.R
import com.kky.example.base.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_text_size.*

/**
 * Author: Zeus
 * Date: 2020/6/24 15:48
 * Description: 文字大小属性
 * History:
 */
class TextSizeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_size)
        textView1.textSize = 18F
        textView2.textSize = resources.getDimension(R.dimen.text_size_18sp)
        textView3.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.text_size_18sp))
        textView4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18F)//默认写法就会调用这种
        //从以上结果看 1,3,4写法都正常。2写法有问题
    }
}