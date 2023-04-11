package com.turreta.maven.kotlin.coroutine

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        println("" + Thread.currentThread() + "codes run in coroutine scope")
        delay(1500)
        println("" + Thread.currentThread() + "codes run in coroutine scope finished")
    }

    println("" + Thread.currentThread() + "blocking #1 is end!")

    runBlocking {
        launch {
            println("" + Thread.currentThread() + "launch1" + this.coroutineContext)
            delay(1000)
            println("" + Thread.currentThread() + "launch1 finished")
        }
        println("" + Thread.currentThread() + "blocking #2.1 launch1 is end!" + this.coroutineContext)
        launch {
            println("" + Thread.currentThread() + "launch2")
            delay(1000)
            println("" + Thread.currentThread() + "launch2 finished")
        }
        println("" + Thread.currentThread() + "blocking #2.2 launch2 is end!")
    }
    println("blocking #2 is end!")


    runBlocking {
        coroutineScope {
            launch {
                for (i in 1..5) {
                    println(i)
                }
            }
        }
        println("coroutineScope finished")
    }
    println("blocking #3 is end!")


    runBlocking {
        val start = System.currentTimeMillis()
        val result1 = async {
            delay(1000)
            5 + 5
        }


        val result2 = async {
            delay(1000)
            4 + 6
        }
        println("result is ${result1.await() + result2.await()}")
        val end = System.currentTimeMillis()
        println("cost: ${end - start} ms.")
    }

    println("blocking #4 is end!")

    runBlocking {
        val result = withContext(Dispatchers.Default) {
            5 + 5
        }
        println(result)
    }
    println("blocking #5 is end!")
}