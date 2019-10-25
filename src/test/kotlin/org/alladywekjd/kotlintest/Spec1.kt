package org.alladywekjd.kotlintest

import io.kotlintest.TestContext
import io.kotlintest.specs.StringSpec

class Spec1 : StringSpec() {
    init {
        "test1" {
            printInfo()
        }
        "test2" {
            printInfo()
        }
    }
}

fun TestContext.printInfo() {
    val test = this.description().fullName()
    val thread = Thread.currentThread().name
    println("$thread: $test")
}