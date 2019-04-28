package kky.com.exam

/**
 * @name DemosSet
 * @author Zeus QQ:1946690608
 * @time 2018/4/21 10:53
 * @change time
 * @class describe
 */
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
