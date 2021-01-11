package com.eus.flex

import android.graphics.Color
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.layout_colors.*

/**
 * Author: Zeus
 * Date: 2020/9/29 11:01
 * Description: 颜色值判断
 * History:
 */
class ColorActivity : AppCompatActivity() {
    private var whiteParsed = 1 //


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_colors)

        var str1 = "kjs0293uskjs0293uskjs0293uskjs0293uskjs0293us"


        try {
            var encodeToString = Base64.encodeToString(str1.toByteArray(Charsets.UTF_8), Base64.NO_WRAP)
            print("after base64 Encode—$encodeToString\n")
            var deCode = Base64.decode(encodeToString, Base64.NO_WRAP)
            var deCodeStr = String(deCode, Charsets.UTF_8)
            print("after base64 Decode-$deCodeStr")
        } catch (e: Exception) {
            if (e != null)
                print("after base64 Exception-$e")
            else
                print("after base64 no exception")
        }

        whiteParsed = Color.parseColor("#FFFFFF")
        val colorAccent = Color.parseColor("#03DAC5")
        print("colorAccent----$colorAccent")
        print("colorParsed----$whiteParsed")
        var whiteInRes = ContextCompat.getColor(this, R.color.colorWhite)
        print("whiteInRes----$whiteInRes")
        print("BlackInRes----" + ContextCompat.getColor(this, R.color.colorBlack))
        var greenInRes = ContextCompat.getColor(this, R.color.colorAccent)
        print("greenInRes----$greenInRes")
        val bgColor1 = title_bar.bgColor
        print("bgColor1----$bgColor1")
        text1.setTextColor(256243100)
    }

    companion object {
        fun print(string: String) {
            Log.e("colors-activity", "===$string")
        }
    }
}