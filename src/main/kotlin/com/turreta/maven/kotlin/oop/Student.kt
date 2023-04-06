package com.turreta.maven.kotlin.oop

class Student(var sno: String, var grade: Int) : Person(), Study {

    init {
        name = "erdai"
        age = 22
    }

    override fun sleep() {
        println("[student] $name is sleep, he is $age years old")
    }

    //声明带一个参数的次构造函数
    constructor(sno: String) : this(sno, 8) {

    }

    //声明一个无参的次构造函数
    constructor() : this("123", 7) {

    }

    fun printInfo() {
        println("I am $name, $age yeas old, sno: $sno, grade: $grade")
    }

    override fun readBooks() {
        println("$name is read book")
    }
}