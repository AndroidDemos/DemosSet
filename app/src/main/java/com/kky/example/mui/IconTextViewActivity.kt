package com.kky.example.mui

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.RadioGroup
import com.kky.example.R
import com.kky.example.base.activity.BaseActivity
import com.kky.example.util.LocalPrinter
import kotlinx.android.synthetic.main.activity_icon_text.*

/**
 * Author: Zeus
 * Date: 2020/9/9 14:52
 * Description: 自定义控件属性
 * History:
 */
class IconTextViewActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_icon_text)
        val xdpi = Resources.getSystem().displayMetrics.xdpi
        val ydpi = Resources.getSystem().displayMetrics.ydpi
        val density = Resources.getSystem().displayMetrics.density
        val densityDpi = Resources.getSystem().displayMetrics.densityDpi
        LocalPrinter.printLocal("xdpi--$xdpi\nydpi--$ydpi\ndensity--$density\ndensityDpi--$densityDpi")
        getBitmap(1, R.mipmap.dpi_m_img)
        getBitmap(2, R.mipmap.dpi_h_img)
        getBitmap(3, R.mipmap.dpi_xh_img)
        getBitmap(4, R.mipmap.dpi_xxh_img)
        radio.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when (checkedId) {
                    R.id.rb_m -> {
                        ImageViewPreviewActivity.start(this@IconTextViewActivity, 1, "mDpi")
                    }
                    R.id.rb_h -> {
                        ImageViewPreviewActivity.start(this@IconTextViewActivity, 2, "hDpi")
                    }
                    R.id.rb_xh -> {
                        ImageViewPreviewActivity.start(this@IconTextViewActivity, 3, "xhDpi")
                    }
                    R.id.rb_xxh -> {
                        ImageViewPreviewActivity.start(this@IconTextViewActivity, 4, "xxhDpi")
                    }
                }
            }
        })
    }

    /**
     * @param op 不能用同一个对象，不然就一致大小

     */
    private fun getBitmap(from: Int, res: Int, op: BitmapFactory.Options? = null) {//
        var bitmap: Bitmap =
            BitmapFactory.decodeResource(resources, res, op)
        LocalPrinter.printLocal("from--$from--" + "byteCount--${bitmap.byteCount}")
        LocalPrinter.printLocal("from--$from--" + "allocationByteCount--${bitmap.allocationByteCount}")
        LocalPrinter.printLocal("from--$from--" + "rowBytes--${bitmap.rowBytes}")
    }
}