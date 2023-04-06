package com.turreta.maven.kotlin.lateinit.sealed

/**
 * 2、使用密封类优化代码
 * 密封类能使我们写出更加规范和安全的代码
 * 1）、使用 sealed class 定义一个密封类
 * 2）、密封类及其子类，只能定义在同一个文件的顶层位置
 * 3）、密封类可被继承
 * 4）、当我们使用条件语句的时候，需要实现密封类所有子类的情况，避免写出永远不会执行的代码
 *
 */

fun main() {
    getResultMsg(Success1())
    getResultMsg(Success2)
}

//在使用密封类之前我们可能会写出这种代码
interface Result1
class Success1 : Result1
class Failure1 : Result1

/**
 * 那么此时如果我新增一个类实现 Result 接口，编译器并不会提示我们去新增新的条件分支
 * 如果我们没有新增相应的条件分支，那么就会出现执行 else 的情况
 * 其实这个 else 就是一个无用分支，这仅仅是为了满足编译器的要求
 */
fun getResultMsg(result: Result1) = when (result) {
    is Success1 -> "Success"
    is Failure1 -> "Failure"
    else -> throw RuntimeException()
}

//在使用密封类之后
sealed class Result2
object Success2 : Result2()
object Failure2 : Result2()

/**
 * 此时我们就避免了写 else 分支，这个时候如果我新增一个类实现 Result 密封类
 * 编译器就会提示异常，需要 when 去新增相应的条件分支
 */
fun getResultMsg(result: Result2) = when (result) {
    is Success2 -> "Success"
    is Failure2 -> "Failure"
}