package org.alladywekjd.kotlintest

import io.kotlintest.specs.StringSpec

class Spec2 : StringSpec() {
    init {
        "test1" {
            printInfo()
        }
        "test2" {
            printInfo()
        }
    }
}