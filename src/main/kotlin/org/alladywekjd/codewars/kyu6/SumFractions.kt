package org.alladywekjd.codewars.kyu6

object SumFractions {

    fun sumFracts(l: Array<IntArray>): String {
        return if (l.isEmpty()) "" else toString(l.reduce { lcd, num -> getSum(lcd, num) }.round())
    }

    private fun getSum(num1: IntArray, num2: IntArray): IntArray {
        val commonDenominator = num1[1] * num2[1] / getGreatestCommonDivisor(num1[1], num2[1])
        val numerator = (num1[0] * (commonDenominator / num1[1])) + (num2[0] * (commonDenominator / num2[1]))
        return intArrayOf(numerator, commonDenominator)
    }

    private fun getGreatestCommonDivisor(a: Int, b: Int): Int {
        var c = if (a > b) b else a
        var d = if (a > b) a else b
        while (d % c != 0) {
            val temp = c
            c = d % c
            d = temp
        }
        return c
    }

    private fun IntArray.round(): IntArray {
        val lcd = getGreatestCommonDivisor(this[0], this[1])
        return intArrayOf(this[0] / lcd, this[1] / lcd)
    }

    private fun toString(num: IntArray): String {
        return if (num[1] == 1) "${num[0]}" else "[${num[0]}, ${num[1]}]"
    }
}