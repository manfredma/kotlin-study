package com.turreta.maven.kotlin.highorderfun

/**
 * 使用内联函数能减少运行时开销，为啥现在又要出来个 noinline 关键字定义不需要内联呢？原因如下：
 * 1、内联函数在编译的时候会进行代码替换，因此它没有真正的参数属性，它的函数类型参数只能传递给另外一个内联函数，而非内联函数的函数类型参数可以自由的传递给其他任何函数
 * 2、内联函数所引用的 Lambda 表达式可以使用 return 关键字来进行函数返回，非内联函数所引用的 Lambda 表达式可以使用 return@Method 语法结构来进行局部返回
 *
 */

fun main() {
    println("main start...")
    val str = ""
    printString(str) {
        println("lambda start...")
        /*
         * 1，非内联函数不能直接使用 return 关键字进行局部返回
         * 2，需要使用 return@printString 进行局部返回
         */
        if (str.isEmpty()) return@printString
        println(it)
        println("lambda end...")
    }

    printStringInline(str) {
        println("lambda start...")
        if (str.isEmpty()) return
        println(it)
        println("lambda end...")
    }
    println("main end...")


}

//使用内联函数定义的高阶函数，其里面的函数类型参数都会进行内联，因此这里使用 noinline 表示我这个函数类型参数不需要内联
inline fun inlineTest(block1: () -> Unit, noinline block2: () -> Unit) {

}


//情况1：非内联函数所引用的 Lambda 表达式可以使用 return 关键字来进行局部返回
//定义一个非内联的高阶函数
fun printString(str: String, block: (String) -> Unit) {
    println("printString start...")
    block(str)
    println("printString end...")
}

//情况2：内联函数所引用的 Lambda 表达式可以使用 return 关键字来进行函数返回
//定义一个非内联的高阶函数
inline fun printStringInline(str: String, block: (String) -> Unit) {
    println("printStringInline start...")
    block(str)
    println("printStringInline end...")
}



