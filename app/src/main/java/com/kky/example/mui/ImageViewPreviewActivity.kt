package com.kky.example.mui

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import com.kky.example.R
import com.kky.example.base.activity.BaseActivity
import com.kky.example.util.LocalPrinter
import kotlinx.android.synthetic.main.activity_image_vew_preview.*


/*
 * @description 根据传参分别展示不同目录下的图片
 * @author Zeus
 * @time 2022/3/24 11:01
 * @change remark
 * @change 2022/3/24 11:01
 */
class ImageViewPreviewActivity : BaseActivity() {
    val fromMDpi = 1
    val fromHDpi = 2
    val fromXHDpi = 3
    val fromXXHDpi = 4
    var from = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_vew_preview)
        tv_title.text = intent.getStringExtra(KEY_TITLE) + "下的图片"
        from = intent.getIntExtra(KEY_FROM, 1)
        val options = BitmapFactory.Options()
        var bitmap: Bitmap =
            BitmapFactory.decodeResource(resources, R.mipmap.dpi_xxh_img, options)
        when (from) {
            fromMDpi -> {
                bitmap = BitmapFactory.decodeResource(resources, R.mipmap.dpi_m_img, options)
            }
            fromHDpi -> {
                bitmap = BitmapFactory.decodeResource(resources, R.mipmap.dpi_h_img, options)
            }
            fromXHDpi -> {
                bitmap = BitmapFactory.decodeResource(resources, R.mipmap.dpi_xh_img, options)
            }
            fromXXHDpi -> {
                bitmap = BitmapFactory.decodeResource(resources, R.mipmap.dpi_xxh_img, options)
            }
        }
        LocalPrinter.printLocal("from--$from--" + "byteCount--${bitmap.byteCount}")
        LocalPrinter.printLocal("from--$from--" + "allocationByteCount--${bitmap.allocationByteCount}")
        LocalPrinter.printLocal("from--$from--" + "rowBytes--${bitmap.rowBytes}")
        iv.setImageBitmap(bitmap)
    }

    companion object {
        val KEY_FROM = "key_from"
        val KEY_TITLE = "key_title"
        fun start(context: Context, from: Int, title: String) {
            var intent = Intent(context, ImageViewPreviewActivity::class.java)
            intent.putExtra(KEY_FROM, from)
            intent.putExtra(KEY_TITLE, title)
            context.startActivity(intent)
        }
    }
}