package com.zeus.kotlinset.kt02

/**
 * Author: Zeus
 * Date: 2020/10/16 15:33
 * Description: kotlin一些用法
 * History:
 */
class FunC {

    fun add(number1: Int, number2: Int): Int {
        return number1 + number2
    }

    fun add2(number1: Int, number2: Int): Int = number1 + number2

    fun add3(number1: Int, number2: Int) = number1 + number2.toDouble()


}