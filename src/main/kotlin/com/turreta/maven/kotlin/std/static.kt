package com.turreta.maven.kotlin.std

import com.turreta.maven.kotlin.basic.logic.largeNumber4

fun main() {
    Util.doAction()

    Util2.doAction()

    Util3.doAction()

    largeNumber4(12, 14)

}

class Util{
    companion object{
        fun doAction(){
            println("do something")
        }
    }
}

object Util2 {
    fun doAction() {
        println("do something")
    }
}

object Util3 {

    @JvmStatic
    fun doAction() {
        println("do something")
    }
}


//2 使用 AndroidStudio 新建一个文件，在弹框中选择 File 即可，我们在这个 File 中编写一个顶层方法
//顶层方法在任何位置都能调用到
fun doAction(){
    println("do something")
}

