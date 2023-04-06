package com.turreta.maven.kotlin.sugar

fun main() {
    // 字符串的内嵌表达式
    val a = "erdai"
    val b = "666"
    println("$a ${a + b}")

    // 方法参数的默认值
    printParams("erdai")

    printParams("erdai", 27)

    printParams(age = 19, name = "erdai")
}

//情况1：定义一个函数时，我们可以给函数的参数添加一个默认值，这样子我们就不需要去传那个参数
fun printParams(name: String, age: Int = 20) {
    println("I am $name, $age years old.")
}

