package com.turreta.maven.kotlin.npe

import com.turreta.maven.kotlin.oop.Student
import com.turreta.maven.kotlin.oop.Study

/**
 * 1、可空类型系统和判空辅助工具
 * 1）、在类型后面加上 ? ，表示可空类型，Kotlin 默认所有的参数和变量不可为空
 * 2）、在对象调用的时候，使用 ?. 操作符，它表示如果当前对象不为空则调用，为空则什么都不做
 * 3）、?: 操作符表示如果左边的结果不为空，返回左边的结果，否则返回右边的结果
 * 4）、在对象后面加 !! 操作符表示告诉Kotlin我这里一定不会为空,你不用进行检测了，如果为空，则抛出空指针异常
 * 5）、let 函数，提供函数式 Api，并把当前调用的对象当作参数传递到 Lambda 表达式中
 */

fun main(args: Array<String>) {
    doStudy(null)
    doStudy2(Student("222", 222))

    var b = "xxx"
    var c = "yyy"
    //平时我们可能写这样的代码
    var a = if (b != null) {
        b
    } else {
        c
    }
    println("$a ")

    //使用 ?: 操作符可以简化成这样
    a = c ?: b

    println("$a ")


    if(name != null){
        printName()
    }
}

val name: String? = "erdai"

fun printName(){
    val upperCaseName = name!!.toUpperCase()
    print(upperCaseName)
}

fun doStudy(study: Study?) {
    study?.readBooks()
    study?.doHomework()
}

fun doStudy2(study: Study?) {
    study?.let {
        it.readBooks()
        it.doHomework()
    }
}