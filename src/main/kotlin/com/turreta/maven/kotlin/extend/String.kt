package com.turreta.maven.kotlin.extend

fun String.printString() {
    println(this)
}

fun main() {
    val name = "erdai"
    name.printString()
}