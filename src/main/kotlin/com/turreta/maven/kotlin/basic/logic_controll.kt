package com.turreta.maven.kotlin.basic.logic

//Kotlin 中把每一个条件中的最后一行代码作为返回值
fun largeNumber4(number1: Int, number2: Int): Int {
    return if (number1 > number2) {
        number1
    } else {
        number2
    }
}

//根据上面学习的语法糖和 Kotlin 类型推导机制，我们还可以简写 largeNumber 函数，最终变成了这样
fun largeNumber5(number1: Int, number2: Int) = if (number1 > number2) number1 else number2


//when 中有参数的情况
fun getScore1(name: String) = when (name) {
    "tom" -> 99
    "jim" -> 80
    "lucy" -> 70
    else -> 0
}

//when 中无参数的情况，Kotin 中判断字符串或者对象是否相等，直接使用 == 操作符即可
fun getScore2(name: String) = when {
    name == "tom" -> 99
    name == "jim" -> 80
    name == "lucy" -> 70
    else -> 0
}


fun main() {
    val number1 = 15
    val number2 = 20
    val maxNumber4 = largeNumber4(number1, number2)
    val maxNumber5 = largeNumber5(number1, number2)
    println("$maxNumber4 - $maxNumber5")

    println(getScore1("tom"))
    println(getScore2("lucy"))

    //使用 .. 表示创建两端都是闭区间的升序区间
    for (i in 0..10) {
        print("$i ")
    }
    println()


    //使用 until 表示创建左端是闭区间右端是开区间的升序区间
    for (i in 0 until 10) {
        print("$i ")
    }
    println()

    for (i in 10 downTo 0) {
        print("$i ")
    }
    println()


    //使用 downTo 表示创建两端都是闭区间的降序区间,每次在跳过3个元素
    for (i in 10 downTo 0 step 3) {
        print("$i ")
    }
    println()


}