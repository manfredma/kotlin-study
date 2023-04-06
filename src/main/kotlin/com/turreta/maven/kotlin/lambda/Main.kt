package com.turreta.maven.kotlin.lambda

fun main() {
    // 集合类的常规使用（创建和遍历）
    testCollectionNormal()

    // 集合的函数式 API
    testCollectionFunApi()

    // Java 函数式 API 的使用
    testJavaFunApi();

}

fun testJavaFunApi() {
    //Kotlin 中可以这么写(实际上是个Object）
    Thread(object : Runnable {
        override fun run() {
            println(Thread.currentThread().toString())
        }
    }).start()

    /**
     * 我们接着来简化 Kotlin 中的写法
     * 因为 Runnable 类中只有一个待实现方法，即使这里没有显示的重写 run() 方法，
     * Kotlin 也能明白后面的 Lambda 表达式就是要在 run() 方法中实现的内容
     */
    Thread(Runnable {
        println(Thread.currentThread().toString())
    }).start()

    //因为是单抽象方法接口，我们可以将接口名进行省略
    Thread({
        println(Thread.currentThread().toString())
    }).start()

    //当 Lambda 表达式作为函数的最后一个参数的时候，我们可以把 Lambda 表达式移到函数括号的外面
    Thread() {
        println(Thread.currentThread().toString())
    }.start()

    //当 Lambda 表达式是函数的唯一参数的时候，函数的括号可以省略
    Thread {
        println(Thread.currentThread().toString())
    }.start()


}

fun testCollectionFunApi(): Unit {
    //定义一个不可变 List 集合
    val list1 = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")
    //现在我想打印集合中英文名字最长的字符串，我们可以这么做
    //方式1
    var maxLengthFruit = ""
    for (fruit in list1) {
        if (fruit.length > maxLengthFruit.length) {
            maxLengthFruit = fruit
        }
    }
    print(maxLengthFruit)

    println()


    //但是如果使用函数式 Api 将会变得更加简单, maxBy 函数会根据你的条件遍历得到符合条件的最大值
    //方式2
    maxLengthFruit = list1.maxBy { it.length }
    print(maxLengthFruit)

    println()

    val lambda = { fruit: String -> fruit.length }
    //maxBy 函数实际上接收的是一个函数类型的参数，后续讲高阶函数的时候会讲到，也就是我们这里可以传入一个 Lambda 表达式
    maxLengthFruit = list1.maxBy(lambda)

    //2 替换 lambda
    maxLengthFruit = list1.maxBy({ fruit: String -> fruit.length })

    //3 Kotlin 中规定，当 Lambda 表达式作为函数的最后一个参数的时候，我们可以把 Lambda 表达式移到函数括号的外面
    maxLengthFruit = list1.maxBy() { fruit: String -> fruit.length }

    //4 Kotlin 中规定，当 Lambda 表达式是函数的唯一参数的时候，函数的括号可以省略
    maxLengthFruit = list1.maxBy { fruit: String -> fruit.length }

    //5 当 Lambda 表达式的参数列表中只有一个参数的时候，我们可以把参数给省略，默认会有个 it 参数
    maxLengthFruit = list1.maxBy { it.length }

    print(maxLengthFruit)

    println()

    //通过 filter 筛选操作，筛选长度小于等于5的字符串
    val newList = list1.filter {
        it.length <= 5
    }
    for (s in newList) {
        print("$s ")
    }
    println()

}

fun testCollectionNormal(): Unit {
    //定义一个不可变 List 集合
    val list1 = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    //定义一个可变 List 集合
    val list2 = mutableListOf("Apple", "Banana", "Orange", "Pear", "Grape")

    list2.add("Watermelon")

    for (i in list2) {
        print("$i ")
    }
    println()

    println(list1.javaClass)
    println(list2.javaClass)

    //Set 集合和 List 集合用法完全一样
    //定义一个不可变 Set 集合
    val set1 = setOf("Apple", "Banana", "Orange", "Pear", "Grape")
    //定义一个可变 Set 集合
    val set2 = mutableSetOf("Apple", "Banana", "Orange", "Pear", "Grape")
    //添加元素
    set2.add("Watermelon")
    for (i in set2) {
        print("$i ")
    }
    println()

    println(set1.javaClass)
    println(set2.javaClass)

    //Map 集合
    //定义一个不可变 Map 集合
    val map1 = mapOf("Apple" to 1, "Banana" to 2, "Orange" to 3, "Pear" to 4, "Grape" to 5)
    //定义一个可变 Map 集合
    val map2 = mutableMapOf("Apple" to 1, "Banana" to 2, "Orange" to 3, "Pear" to 4, "Grape" to 5)
    //当前 key 存在则修改元素，不存在则添加元素
    map2["Watermelon"] = 6
    for ((key, value) in map2) {
        print("$key: $value ")
    }

    println()

    println(map1.javaClass)
    println(map2.javaClass)
}