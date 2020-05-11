package org.alladywekjd.codewars.kyu6

import io.kotlintest.specs.StringSpec
import org.alladywekjd.codewars.kyu5.ToSmallest
import org.junit.jupiter.api.Assertions.assertEquals

class ToSmallestTest : StringSpec() {

    init {

        "return the same number if number is already the smallest"() {
            testing(0L, "[0, 0, 0]")
            testing(1L, "[1, 0, 0]")
            testing(12L, "[12, 0, 0]")
            testing(127L, "[127, 0, 0]")
            testing(12469L, "[12469, 0, 0]")
        }

        "return the positive number if number is negative"() {
            testing(-0L, "[0, 0, 0]")
            testing(-1L, "[1, 0, 0]")
            testing(-12L, "[12, 0, 0]")
            testing(-127L, "[127, 0, 0]")
            testing(-12469L, "[12469, 0, 0]")
        }

        "kata tests"() {
            testing(-21L, "[12, 0, 1]")
            testing(-142L, "[124, 1, 2]")
            testing(-1942L, "[1294, 3, 1]")
            testing(9219L, "[1929, 2, 0]")
            testing(1292L, "[1229, 2, 3]")

            testing(261235, "[126235, 2, 0]")
            testing(285365, "[238565, 3, 1]")
            testing(269045, "[26945, 3, 0]")
            testing(209917, "[29917, 0, 1]")
            testing(199819884756, "[119989884756, 4, 0]")
            testing(1000000, "[1, 0, 6]")
            testing(8871195798486626, "[1887195798486626, 3, 0]")
        }
    }

    private fun testing(n: Long, expect: String) {
        val actual = ToSmallest.smallest(n).contentToString()
        assertEquals(expect, actual)
    }
}