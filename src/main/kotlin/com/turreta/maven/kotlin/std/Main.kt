package com.turreta.maven.kotlin.std

fun main() {
    /*
     * 情况1：let 函数
     * 1、创建一个 StringBuilder 对象调用 let 函数，Lambda 表达式中的参数为 StringBuilder 对象
     * 2、当 Lambda 表达式中只有一个参数的时候可省略，默认会有个 it 的参数，返回值即为 Lambda 表达式中最后一行代码
     */
    val name = "erdai"
    val age = 20
    var returnValue = StringBuilder().let {
        it.append(name).append(" ").append(age)
    }
    println(returnValue)

    /*
     * 情况2：also 函数
     * 1、创建一个 StringBuilder 对象调用 also 函数，Lambda 表达式中的参数为 StringBuilder 对象
     * 2、当 Lambda 表达式中只有一个参数的时候可省略，默认会有个 it 的参数，无法指定返回值，返回调用对象本身
     */
    var stringBuilder = StringBuilder().also {
        it.append(name).append(" ").append(age)
    }
    println(stringBuilder.toString())


    /*
     * 情况3：with 函数
     * 1、接收两个参数，第一个参数为 StringBuilder 对象，第二个参数为 Lambda 表达式，
     * 2、Lambda 表达式中拥有 StringBuilder 对象的上下文 this, 返回值即为 Lambda 表达式中的最后一行代码
     */

    returnValue = with(StringBuilder()) {
        append(name).append(" ").append(age)
    }
    println(returnValue)


    /*
     * 情况4：run 函数
     * 1、创建一个 StringBuilder 对象调用 run 函数，Lambda 表达式中拥有 StringBuilder 对象的上下文 this
     * 2、返回值即为 Lambda 表达式中的最后一行代码
     */
    returnValue = StringBuilder().run {
        append(name).append(" ").append(age)
    }
    println(returnValue)

    /*
     * 情况5：apply 函数
     * 1、创建一个 StringBuilder 对象调用 apply 函数，Lambda 表达式中拥有 StringBuilder 对象的上下文 this
     * 2、无法指定返回值，返回调用对象本身
     */
    stringBuilder = StringBuilder().apply {
        append(name).append(" ").append(age)
    }
    println(stringBuilder.toString())

}