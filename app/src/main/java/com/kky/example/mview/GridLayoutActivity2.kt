package com.kky.example.mview

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gridlayout2)
        var gvCalculate = gv_calculate
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