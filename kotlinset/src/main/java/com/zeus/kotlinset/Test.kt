package com.zeus.kotlinset

import android.os.Build
import android.util.Base64
import androidx.annotation.RequiresApi
import java.nio.charset.Charset

/**
 * Author: Zeus
 * Date: 2020/10/22 18:14
 * Description: 任意测试
 * History:
 */
@RequiresApi(Build.VERSION_CODES.O)
fun main() {
    var str1 = "kjs0293uskjs0293uskjs0293uskjs0293uskjs0293us"


    try {
        var encodeToString = Base64.encodeToString(str1.toByteArray(Charsets.UTF_8), Base64.NO_WRAP)
        print("after base64Encode—$encodeToString\n")
        var deCode = Base64.decode(str1, Base64.NO_WRAP)
        print("after base64Decode-$deCode")
    } catch (e: Exception) {
        print("after Exception-$e")
    }
}