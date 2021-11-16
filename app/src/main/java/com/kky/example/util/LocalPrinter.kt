package com.kky.example.util

import android.util.Log

/*
* @author Zeus
* create at 2020/5/16 14:40
* modify at 2020/5/16 14:40
* modify because 
* description: TO FIT
*/
object LocalPrinter {
    private const val zeusLog = true

    @JvmStatic
    fun printLocal(content: String) {
        if (zeusLog) {
            Log.e("zeus-tag", content)
        }
    }
}