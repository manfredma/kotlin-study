package com.turreta.maven.kotlin.highorderfun

/**
 * 高阶函数和 Lambda 表达式是密不可分的.
 * 函数式 Api 的用法有一个共同的特点：需要传入一个 Lambda 表达式作为参数。
 *
 * 像这种接收 Lambda 表达式的函数我们就可以称之为具有函数式编程风格的 Api
 *
 */

fun example(func: (String, Int) -> Unit) {
    func("erdai", 666)
}

//我们使用高阶函数来获取两个数相加的和
inline fun numberPlus(num1: Int, num2: Int, func: (Int, Int) -> Int): Int {
    val sum = func(num1, num2)
    return sum
}

fun plus(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun minus(num1: Int, num2: Int): Int {
    return num1 - num2
}


fun main() {
    //
    example { a, b ->
        println("$a --> $b")
    }

    // 调用高阶函数的两种方式
    // 方式1：成员引用，使用 ::plus，::minus这种写法引用一个函数
    var numberPlus = numberPlus(10, 20, ::plus)
    var numberMinus = numberPlus(10, 20, ::minus)
    println(numberPlus)
    println(numberMinus)

    //方式2：使用 Lambda 表达式的写法
    numberPlus = numberPlus(10, 20) { num1, num2 ->
        num1 + num2
    }
    numberMinus = numberPlus(10, 20) { num1, num2 ->
        num1 - num2
    }
    println(numberPlus)
    println(numberMinus)

    // Kotlin 编译器会把内联函数中的代码在编译的时候自动替换到调用它的地方 ，这样也就不存在运行时的开销了


}