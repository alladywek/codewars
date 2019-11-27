package org.alladywekjd.codewars.kyu6

import io.kotlintest.specs.StringSpec
import org.junit.jupiter.api.Assertions.assertEquals


class SumFractionsTest : StringSpec() {

    fun testing(actual: String, expected: String) {
        assertEquals(expected, actual)
    }

    init {
        "test normal condition" {
            var a = arrayOf(intArrayOf(1, 2), intArrayOf(2, 9), intArrayOf(3, 18), intArrayOf(4, 24), intArrayOf(6, 48))
            var r = "[85, 72]"
            testing(SumFractions.sumFracts(a), r)

            a = arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(1, 4))
            r = "[13, 12]"
            testing(SumFractions.sumFracts(a), r)

            a = arrayOf(intArrayOf(2, 4), intArrayOf(20, 4), intArrayOf(10, 4))
            r = "8"
            testing(SumFractions.sumFracts(a), r)

            a = arrayOf(intArrayOf(15, 1), intArrayOf(13, 1))
            r = "28"
            testing(SumFractions.sumFracts(a), r)

            a = arrayOf()
            r = ""
            testing(SumFractions.sumFracts(a), r)
        }
    }
}