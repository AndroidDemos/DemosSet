package com.kky.example.test

/**
 * @name DemosSet
 * @author Zeus QQ:1946690608
 * @time 2018/4/10 10:35
 * @change time
 * @class describe
 */
class Sichuan(sex: Boolean, region: String) : Chinese(sex, region) {
    var dialet = "四川话"
    override var skin = "四川话"
    override fun cook() {
        super.cook()
        val menu= arrayOf("麻婆豆腐","烤鱼")
        val desc=menu.reduce{s1,s2->s1+","+s2}
        print("我会${desc}")//我会麻婆豆腐,烤鱼
    }
    fun main(args:Array<String>){
        //实例化一个类
        val yaoming=Shanghair(true,"sh")
        yaoming.avg=3000
        println(yaoming.region)//-->>ah
        print(yaoming.dialet)//--->>上海话
        yaoming.cook()

        val guojinming=Sichuan(true,"sc")
        guojinming.cook()
    }
}