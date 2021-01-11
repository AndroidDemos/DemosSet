package com.eus.flex

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv1.setText(getNormal("1E11"))
        tv2.setText(showAmountStr(0.1))
        tv3.setText(showAmountStr(100.0))
        tv4.setText(getNDec(0.0, 2).toString())
        tv5.setText(getNDec(0.1, 2).toString())
        tv6.setText(getNDec(100.0, 2).toString())
        tv7.setText(showAmountStr2(77777777777777.0).toString())
        tv8.setText(showAmountStr2(0.8).toString())
        tv9.setText(showAmountStr2(9999.0).toString())
        tv10.setText(showAmountStr2(100000.02321).toString())
        tv11.setText(showAmountStr2(111111111111111111111111111.13132).toString())
        tv12.setText(showAmountStr2(0.1).toString())
    }


    /**
     * 保留小数点后两位，千位隔开
     * @param num
     * @return
     */
    fun showAmountStr(num: Double): String? {
        val bd = BigDecimal(num)
        return if (num == 0.0) {
            "0.00"
        } else {
//            var pattern = ",###,###.00"
            var pattern = "###,###0.00"
//            if (num < 1000) {
//                pattern = "0.00"
//            }
            parseNumber(pattern, bd)
        }
    }

    /**
     * 保留小数点后两位，千位隔开
     * @param num
     * @return
     */
    fun showAmountStr2(num: Double): String? {
        val bd = BigDecimal(num)

//        var pattern = "###,###0.00"//4位一逗，保留一位
        var pattern = "###,##0.00"//3位一逗，保留一位
//            var pattern = ",###,###.00"
//            if (num < 1000) {
//                pattern = "0.00"
//            }
        return parseNumber(pattern, bd)

    }

    fun parseNumber(pattern: String?, bd: BigDecimal?): String? {
        val df = DecimalFormat(pattern)
        return df.format(bd)
    }

    fun getNormal(num: String): String {
        val df = BigDecimal(num)
        return df.toString()
    }

    /**
     *保留几位小数
     * @param d 要转换的小数
     * @param pos 要保留的位数
     */
    fun getNDec(d: Double, pos: Int): Double {
        var big = BigDecimal(d)
        val scale = big.setScale(pos, BigDecimal.ROUND_HALF_UP)
        Log.e("scale -value", scale.toString())
        var newD = scale.toDouble()
        return newD
    }


}
