package com.kky.example.mview

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Base64
import androidx.core.content.contentValuesOf
import com.kky.example.R
import com.kky.example.base.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_gridlayout2.*
import java.math.BigDecimal
import java.text.DecimalFormat

/**
 * Author: Zeus
 * Date: 2020/7/22 14:29
 * Description: xml布局
 * History:
 */
class GridLayoutActivity2 : BaseActivity() {
    var base64Str = "data:image/png;base64,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"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gridlayout2)
        var gvCalculate = grid_layout
        bt_red_packet.setOnClickListener {
            val parse = Uri.parse("openapp://test:8000/detail?title=电视影音&url=https://u.jd.com/1dfFwO")
            var intent = Intent()
            intent.setData(parse)
            startActivity(intent)
        }
        bt_test_params.setOnClickListener {
            val parse = Uri.parse("juancashs://redbag/Qyvv2KxHIpk=")
            var intent = Intent()
            intent.setData(parse)
            startActivity(intent)
        }
        getSharedPreferences("LLL", Context.MODE_PRIVATE).edit().putBoolean("xssfd", false)
//        val systemService = getSystemService(Context.WINDOW_SERVICE) as WindowManager
//        val contentValues = ContentValues()
//        contentValues.put("name","sfsf")
//        contentValues.put("age",20)
        val contentValues = contentValuesOf(Pair("name", "taonce"), "age" to 20, "gender" to 2.0)
        tv1.setText(showAmountStr(0.0))
        tv2.setText(showAmountStr(2.0))
        tv3.setText(showAmountStr(100.0))
        tv4.setText(showAmountStr(100000000000.0))
        var intpu = base64Str.substring(base64Str.lastIndexOf(',') + 1, base64Str.length)
        val byte = getByte(intpu)
        var bitmap = BitmapFactory.decodeByteArray(byte, 0, byte.size)
        iv_center.setImageBitmap(bitmap)
//        Encode
    }

    fun getByte(input: String): ByteArray {
        return if (input == null || input.length == 0) ByteArray(0) else Base64.decode(input, Base64.NO_WRAP)
    }


    fun showAmountStr(num: Double): String? {
        val bd = BigDecimal(num)
        val s: String = parseNumber(",###,###.00", bd)
        return s
    }

    fun parseNumber(pattern: String, bd: BigDecimal): String {
        val df = DecimalFormat(pattern)
        return df.format(bd)
    }

}