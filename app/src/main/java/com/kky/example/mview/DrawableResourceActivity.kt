package com.kky.example.mview

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.drawable.ClipDrawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import com.kky.example.MainActivity
import com.kky.example.R
import com.kky.example.base.activity.BaseActivity
import com.kky.example.widget.image.HexagonDrawable
import kotlinx.android.synthetic.main.activity_drawable_resource.*

/**
 * drawable相关用法
 */
class DrawableResourceActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawable_resource)
        initView()
        initData()
    }

    private fun initView() {
        iv1.setImageResource(R.drawable.score)
        iv2.setImageResource(R.drawable.score)
        iv3.setImageResource(R.drawable.score)
        iv4.setImageDrawable(HexagonDrawable(BitmapFactory.decodeResource(resources, R.drawable.inset)))
        iv1.setImageLevel(0)
        iv2.setImageLevel(1)
        iv3.setImageLevel(2)// ImgeView.setImageLevel相关用法，不同状态可以用上
        BottomSheetActivity().apply {
        }
        var drableTransition = getDrawable(R.drawable.g_transition) as TransitionDrawable//Image渐变
        drableTransition.startTransition(1000)
//        drableTransition.reverseTransition(1000)
        iv11.setImageDrawable(drableTransition)
        var insetDrawable = getDrawable(R.drawable.inset)//除了加点边距，也没啥功效个人感觉
        iv21.setImageDrawable(insetDrawable)
        var clipDrawable = getDrawable(R.drawable.clip) as ClipDrawable//图片裁剪，范围0-10000
        var clipDrawable5 = getDrawable(R.drawable.clip) as ClipDrawable

        iv31.setImageDrawable(clipDrawable)
        iv32.setImageDrawable(clipDrawable5)
        clipDrawable.level = 2000//裁剪，范围0-10000,值越高裁剪的部分越小
        clipDrawable5.level = 5000
//        var mixDrawable = iv41.drawable as ClipDrawable
//        mixDrawable.level = 9000
        iv1.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)//singleTask模式的activity重新打开直接走onNewIntent方法
            this.startActivity(intent)
        }
    }

    private fun initData() {


    }
}