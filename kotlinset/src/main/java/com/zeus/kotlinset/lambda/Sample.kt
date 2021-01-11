package com.zeus.kotlinset.lambda

/**
 * Author: Zeus
 * Date: 2020/10/16 15:37
 * Description:
 * History:
 */
class Sample {
    fun main(args: Array<String>) {
        val method: (String, String) -> Unit = { aStr, bStr -> println("a:$aStr,b:$bStr") }
        method("Derry","男")
    }
}