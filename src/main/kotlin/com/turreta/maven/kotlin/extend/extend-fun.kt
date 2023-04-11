package com.turreta.maven.kotlin.extend

/**
 * 扩展String中的方法
 */
fun String.printString() {
    println(this)
}

class Jump {
    fun test() {
        println("jump test")
        //在被扩展的类中使用 -- 预留的扩展点！
        doubleJump(1f)
    }
}

fun Jump.doubleJump(howLong: Float): Boolean {
    println("jump:$howLong")
    println("jump:$howLong")
    return true
}

fun main() {
    val name = "erdai"
    name.printString()

    Jump().test()
    Jump().doubleJump(2.0F)

    Jump().test()

}