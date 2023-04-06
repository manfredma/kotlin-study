package com.turreta.maven.kotlin.oop

//定义的一个方法 然后在main函数调用
fun doStudy(study: Study){
    study.readBooks()
    study.doHomework()
}


fun main() {
    val p = Person();
    p.name = "erdai"
    p.age = 20
    p.sleep()

    val p2 = Student();
    p2.sleep()
    p2.printInfo()

    val student: Study = Student("erdai",20)
    //这里student实现了Study接口,这种叫做面向接口编程,也可以称为多态
    doStudy(student)

    // 使用单例类
    Singleton.singletonTest()

    // 使用数据类
    val cellphone = Cellphone("小米", 20.0);
    val cellphone2 = Cellphone("小米", 20.0);

    println(cellphone == cellphone2)

    println(cellphone.javaClass)

}
