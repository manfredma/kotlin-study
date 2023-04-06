package com.turreta.maven.kotlin.lateinit.sealed

//情况1：使用 lateinit 关键字对一个变量延迟初始化
lateinit var name1: String

//情况2: 使用 ::object.isInitialized 这种固定的语法结构判断变量是否已经初始化
lateinit var name2: String

//情况3: 使用 by lazy 对一个变量延迟初始化
//特点：该属性调用的时候才会初始化，且 lazy 后面的 Lambda 表达式只会执行一次
val name3: String by lazy {
    "erdai"
}

fun main() {
    if (::name1.isInitialized) {
        println(name1)
    } else {
        println("name not been initialized")
    }

    name2 = "erdai"
    println(name2)

    println(name3)
}
