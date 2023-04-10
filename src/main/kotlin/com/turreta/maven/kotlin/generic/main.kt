package com.turreta.maven.kotlin.generic

//1、定义一个泛型类，在类名后面使用 <T> 这种语法结构就是为这个类定义一个泛型
class MyClassG<T> {
    fun method(params: T) {

    }
}

//2、定义一个泛型方法，在方法名的前面加上 <T> 这种语法结构就是为这个方法定义一个泛型
class MyClassG2 {
    fun <T> method(params: T) {

    }
}

//3、定义一个泛型接口，在接口名后面加上 <T> 这种语法结构就是为这个接口定义一个泛型
interface MyInterfaceG3<T> {
    fun interfaceMethod(params: T)
}

// 边界 =========================================================================================================
// 情况1 单个边界
class MyClassG3<T : Number> {

    var data: T? = null

    fun <T : Number> method(params: T) {

    }
}

// 情况2 多个边界使用 where 关键字
open class Animal
interface Food
interface Food2

class MyClassG4<T> where T : Animal, T : Food, T : Food2 {

    fun <T> method(params: T) where T : Animal, T : Food, T : Food2 {

    }
}

// 实化 =========================================================================================================
inline fun <reified T> getGenericType() = T::class.java


// 逆变、协变和不变 =========================================================================================================
open class Person
class Student : Person()
class Teacher : Person()

class SimpleData<out T> {

}

class SimpleData2<in T>{

}

class SimpleData3<T>{

}

class KotlinGeneric<out T: Number>{

}


fun main() {
    // 类泛型调用
    val myClassG = MyClassG<Int>()
    myClassG.method(12)
    // 方法泛型调用
    val myClassG2 = MyClassG2()
    myClassG2.method<Int>(12)
    //根据 Kotlin 类型推导机制，我们可以把泛型给省略
    myClassG2.method(12)

    //泛型实化 这种情况在 Java 是会被类型擦除的
    val result1 = getGenericType<String>()
    val result2 = getGenericType<Number>()
    println(result1)
    println(result2)


    // 协变
    val person: Person = Student()
    val personGeneric: SimpleData<Person> = SimpleData<Student>()
    val list1: ArrayList<out Person> = ArrayList<Student>()

    // PECS --
    // list1.add(person)
    val person2: Person = list1[0]

    // 逆变
    val personGeneric2: SimpleData2<Student> = SimpleData2<Person>()

    // 不变
    // val personGeneric3: SimpleData3<Person> = SimpleData3<Student>()


    val noBound: KotlinGeneric<*> = KotlinGeneric<Int>()

    //根据协变规则 编译器不允许这样写
    // val noBound: KotlinGeneric<*> = KotlinGeneric<Any>()


}
