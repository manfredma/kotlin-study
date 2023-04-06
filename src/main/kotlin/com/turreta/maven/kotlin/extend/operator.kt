package com.turreta.maven.kotlin.extend

class Money(val value: Int) {

    //实现运算符重载 Money + Money
    operator fun plus(money: Money): Money {
        val sum = value + money.value
        return Money(sum)
    }

    //实现运算符重载 Money + Int
    operator fun plus(money: Int): Money{
        val sum = value + money
        return Money(sum)
    }
}

fun main() {
    val money1 = Money(15)
    val money2 = Money(20)
    val money3 = money1 + money2
    val money4 = money3 + 15
    println(money3.value)
    print(money4.value)
}
