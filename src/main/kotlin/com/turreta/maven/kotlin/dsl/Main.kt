package com.turreta.maven.kotlin.dsl

class Dependency {

    fun implementation(lib: String){
        println("implementation : $lib")
    }
}

fun dependencies(block: Dependency.() -> Unit){
    val dependency = Dependency()
    dependency.block()
}

fun dependenciesV2(block: (Dependency) -> Unit){
    block(Dependency())
}

fun main() {
    //因为 Groovy 和 Kotlin 语法不同，因此写法会有一点区别
    dependencies {
        implementation ("androidx.core:core-ktx:1.3.2")
        implementation ("androidx.appcompat:appcompat:1.2.0")
    }

    dependenciesV2 {
        it.implementation ("androidx.core:core-ktx:1.3.2")
        it.implementation ("androidx.appcompat:appcompat:1.2.0")
    }
}

