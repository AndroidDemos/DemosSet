package com.kky.example.mview

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.kky.example.R
import com.kky.example.ZeusApp
import com.kky.example.base.activity.BaseActivity
import com.kky.example.util.LocalPrinter
import kotlinx.android.synthetic.main.activity_snack_bar.*
import java.math.BigDecimal

/*
 * @description snackbar用法
 * @author Zeus
 * @time 2022/3/30 16:12
 * @change remark
 * @change 2022/3/30 16:12
 */
class SnackBarActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snack_bar)
        val ii = 11.00
        button1.setOnClickListener {
            Snackbar.make(it, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action1", object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        Toast.makeText(ZeusApp.getContext(), "msg", Toast.LENGTH_SHORT).show()
                    }
                }).show()
        }
        button2.setOnClickListener {

            Snackbar.make(it, "Replace with your own action", Snackbar.LENGTH_SHORT)
                .setAction("Action2", null).show()
        }
        button3.setOnClickListener {
            Snackbar.make(it, "Replace with your own action", Snackbar.LENGTH_INDEFINITE)
                .setAction("Action3", null).show()
        }
        var aa = "111.00"
        var bb = "111.12"
        var cc = "111"
        LocalPrinter.printLocal(Integer.parseInt(aa).toString()+"\n")
        LocalPrinter.printLocal(getPureDouble(bb)+"\n")
        LocalPrinter.printLocal(getPureDouble(cc))
    }
    fun getPureDouble(data: String): String {//固定保留两位小数
        var big = BigDecimal(data)
        var newD = big.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString()//不使用科学计数法
        return newD
    }

}