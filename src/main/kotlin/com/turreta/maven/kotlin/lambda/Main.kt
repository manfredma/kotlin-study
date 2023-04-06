package com.turreta.maven.kotlin.lambda

fun main() {
    // 集合类的常规使用（创建和遍历）
    // testCollectionNormal()

    // 集合的函数式 API
    testCollectionFunApi()

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
//    maxLengthFruit = list1.maxBy({ it ->
//        it.length
//    })

    maxLengthFruit = list1.maxBy { it.length }
    print(maxLengthFruit)

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