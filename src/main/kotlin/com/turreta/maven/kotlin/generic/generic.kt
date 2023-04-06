package com.turreta.maven.kotlin.generic

fun main() {
    // 类泛型调用
    val myClass = MyClass<Int>()
    myClass.method(12)

    // 方法泛型调用
    val myClassV2 = MyClassV2()
    myClassV2.method<Int>(12)
    //根据 Kotlin 类型推导机制，我们可以把泛型给省略
    myClassV2.method("12X")

    val myClassV3 = MyClassV3()
    myClassV3.method<Int>(12)
    // myClassV3.method("12")
}

//1、定义一个泛型类，在类名后面使用 <T> 这种语法结构就是为这个类定义一个泛型
class MyClass<T> {
    fun method(params: T) {
        println(params)
    }
}


//2、定义一个泛型方法，在方法名的前面加上 <T> 这种语法结构就是为这个方法定义一个泛型
class MyClassV2 {
    fun <T> method(params: T) {
        println(params)
    }
}


//3、定义一个泛型接口，在接口名后面加上 <T> 这种语法结构就是为这个接口定义一个泛型
interface MyInterface<T> {
    fun interfaceMethod(params: T) {
        println(params)
    }
}

class MyClassV3{
    //我们指定了泛型的上界为 Number, 那么我们就只能传入数字类型的参数了
    fun <T : Number> method(params: T) {
        println(params)
    }
}

