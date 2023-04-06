package com.turreta.maven.kotlin.oop

//定义接口中的一系列的抽象行为 Kotlin 中增加了接口中定义的函数可以有默认实现，其实 Java 在 JDK1.8 之后也开始支持这个功能
interface Study {
    fun readBooks()

    //如果子类没有重写这个方法,那么就会调用这个方法的默认实现
    fun doHomework() {
        println("do homework default implementation")
    }
}

