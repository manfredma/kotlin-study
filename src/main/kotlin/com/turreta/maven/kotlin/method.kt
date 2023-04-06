package com.turreta.maven.kotlin.method

import java.lang.Integer.max

// 定义函数(方法）
fun methodName(param1: Int, param2: Int): Int {
    return 0
}

//下面这两个方法效果是一样的
fun methodName1(params: Int, params2: Int): Unit {

}

fun methodName2(params: Int, params2: Int) {

}

fun main() {
    val number1 = 15
    val number2 = 20
    val maxNumber = largeNumber(number1, number2)
    val maxNumber2 = largeNumber2(number1, number2)
    val maxNumber3 = largeNumber3(number1, number2)
    println("$maxNumber - $maxNumber2 - $maxNumber3")
}

fun largeNumber(number1: Int,number2: Int) : Int{
    //调用顶层 max 函数计算两者中的最大值
    return max(number1, number2)
}

//根据上述语法糖，我们省略了函数体的 {} 和 return 关键字，增减的 = 连接
fun largeNumber2(number1: Int, number2: Int): Int = max(number1, number2)

//根据 Kotlin 类型推导机制，我们还可以把函数的返回值给省略，最终变成了这样
fun largeNumber3(number1: Int, number2: Int) = max(number1, number2)





