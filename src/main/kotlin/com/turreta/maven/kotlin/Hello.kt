package com.turreta.maven.kotlin.hello

import com.turreta.maven.kotlin.Boot
import java.lang.Integer.max

fun sayHello() {
    println("Hello, World")
}

fun main() {
    val number1 = 15
    val number2 = 20
    val maxNumber = largeNumber(number1,number2)
    println(maxNumber)
    sayHello()

    Boot().main(null)
}

fun largeNumber(number1: Int,number2: Int) : Int{
    //调用顶层 max 函数计算两者中的最大值
    return max(number1, number2)
}
