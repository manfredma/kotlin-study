package com.turreta.maven.kotlin.infix

// 对 String 增加一个扩展的 infix 函数，最终调用的还是 String 的 startsWith 函数
infix fun String.beginWith(string: String) = startsWith(string)

infix fun <A, B> A.with(that: B): Pair<A, B> = Pair(this, that)


fun main() {
    val name = "erdai"
    println(name beginWith "er")

    val map = mapOf("Apple" with 1, "Banana" with 2, "Orange" with 3, "Pear" with 4, "Grape" with 5)

    map.forEach { (a, b) ->
        println("$a : $b")
    }
}

