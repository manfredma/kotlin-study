package com.turreta.maven.kotlin.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main() {
    println("" + Thread.currentThread() + ": Main function")
    GlobalScope.launch {
        println("" + Thread.currentThread() + ": launch function")
        println("codes run in coroutine scope")
    }
    System.`in`.read();

}