package com.turreta.maven.kotlin.delegate

import kotlin.reflect.KProperty

fun main() {
    var mySet: MutableSet<String> = MySet<String>(HashSet());

    mySet.add("112")
    mySet.add("111")
    mySet.add("110")
    mySet.add("111")
    for (s in mySet) {
        print("$s ")
    }
    println()

    var mySetV2 = MySetV2<String>(HashSet());
    mySetV2.add("112")
    mySetV2.add("111")
    mySetV2.add("110")
    mySetV2.add("111")

    for (s in mySetV2) {
        print("$s ")
    }
    println()

    var myClass = MyClass()
    println(myClass.p)

}

//定义一个 MySet 类，它里面的具体实现都委托给了 HashSet 这个类，这是是类委托
class MySet<T>(val helperSet: HashSet<T>) : MutableSet<T> {

    override val size: Int get() = helperSet.size
    override fun clear() = helperSet.clear()

    override fun addAll(elements: Collection<T>): Boolean = helperSet.addAll(elements)
    override fun add(element: T): Boolean = helperSet.add(element)

    override fun contains(element: T) = helperSet.contains(element)

    override fun containsAll(elements: Collection<T>) = helperSet.containsAll(elements)

    override fun isEmpty() = helperSet.isEmpty()

    override fun iterator() = helperSet.iterator()
    override fun retainAll(elements: Collection<T>): Boolean = helperSet.retainAll(elements)

    override fun removeAll(elements: Collection<T>): Boolean = helperSet.removeAll(elements)

    override fun remove(element: T): Boolean = helperSet.remove(element)
}

/**
 * 如果我们使用 by 关键字，上面的代码将会变得非常整洁，同时我们可以对某个方法进行重写或者新增方法
 * 那么 MySet 就变成了一个全新的数据结构类
 */
class MySetV2<T>(val helperSet: HashSet<T>) : MutableSet<T> by helperSet {
    fun helloWord() {
        println("Hello World")
    }

    override fun isEmpty() = false
}

/**
 * 使用 by 关键字连接了左边的 p 属性和右边的 Delegate 实例
 * 这种写法就代表着将 p 属性的具体实现委托给了 Delegate 去完成
 */
class MyClass {

    var p by Delegate()
}

/**
 * 下面是一个被委托类的代码实现模版
 * 一、getValue 方法和setValue 方法必须使用 operator 关键字修饰
 *
 * 二、getValue 方法主要接收两个参数：
 * 1、第一个参数表明 Delegate 类的委托功能可以在什么类中使用
 * 2、第二个参数 KProperty<*> 是 Kotlin 中的一个属性操作类，
 *    可用于获取各种属性的相关值，<*>这种泛型的写法类似 Java 的
 *    <?>，表示我不关心泛型的具体类型
 *
 * 三、setValue 方法也是相似的，接收三个参数：
 * 1、前面两个参数和 getValue 是一样的
 * 2、第三个参数表示具体要赋值给委托属性的值，这个参数的类型必须和
 *    getValue 方法返回值的类型保持一致
 *
 *
 * 一种特殊情况：用 val 定义的变量不需要实现 setValue 方法，因为 val
 *             关键字声明的属性只可读，赋值之后就不能更改了
 */
class Delegate {

    var propValue: Any? = "xxx"

    operator fun getValue(any: Any?, prop: KProperty<*>): Any? {
        return propValue
    }

    operator fun setValue(any: Any?, prop: KProperty<*>, value: Any?) {
        propValue = value
    }
}
