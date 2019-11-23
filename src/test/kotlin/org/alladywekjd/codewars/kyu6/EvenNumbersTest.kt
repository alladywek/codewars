package org.alladywekjd.codewars.kyu6

import io.kotlintest.specs.StringSpec
import org.junit.jupiter.api.Assertions.assertEquals

class EvenNumbersTest: StringSpec() {

    init {
        "even numbers test" {
            assertEquals(listOf(4, 6, 8), evenNumbers(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 3))
            assertEquals(listOf(-8, 26), evenNumbers(listOf(-22, 5, 3, 11, 26, -6, -7, -8, -9, -8, 26), 2))
            assertEquals(listOf(6), evenNumbers(listOf(6, -25, 3, 7, 5, 5, 7, -3, 23), 1))
        }
    }
}