package com.kky.example.test

/**
 * @name DemosSet
 * @author Zeus QQ:1946690608
 * @time 2018/4/10 10:21
 * @change time
 * @class describe
 */
open class Chinese constructor(var sex: Boolean, var region: String) {
    //普通属性，与变量定义相似
    protected open var skin = "yellow"
    //组合属性，由其他属性计算而来
    val avgLife: Double
        get() {
            when (this.region) {
                "sh" -> return 82.4
                "ah" -> return 77.8
                else -> return 73.4
            }
        }
    //组合属性可以影响其他属性（set,可选），this代表实例
    var avg: Int
        get() {
            when (this.region) {
                "sh" -> return 4900
                "ah" -> return 3200
                else -> return 3500
            }
        }
        set(value) {
            when (value) {
                in 4500..Int.MAX_VALUE -> {
                    this.region = "sh"
                }
                in 2800..3500 -> {
                    this.region = "ah"
                }
                else -> {
                    this.region = "other"
                }
            }
        }

    //方法
    open fun cook() {
        val menu= arrayOf("青椒肉丝","番茄鸡蛋","紫菜汤")
        val desc=menu.reduce { s1, s2 ->s1+","+s2  }//连接
        print("我会${desc}")//---->>我会青椒肉丝,番茄鸡蛋,紫菜汤
    }
}