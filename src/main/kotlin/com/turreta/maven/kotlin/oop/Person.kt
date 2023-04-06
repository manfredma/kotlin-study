package com.turreta.maven.kotlin.oop

open class Person {

    var name: String = ""

    var age: Int = 0

    open fun sleep() {
        println("$name is sleep, he is $age years old")
    }
}