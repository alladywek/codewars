package org.alladywekjd.codewars.kyu6

object SumFractions {

    fun sumFracts(l: Array<IntArray>): String {
        if (l.isEmpty()) return ""
        val denominatorsExpr = l.map { it[1] }.reduce { sum, denominator -> sum * denominator }
        return toString(getSum(l, denominatorsExpr))
    }

    private fun getSum(l: Array<IntArray>, lcm: Int): Pair<Int, Int> {
        val (a, b) = l.map { it[0] * (lcm / it[1]) }.sum().let { Pair(it, lcm) }
        var c = if (a > b) b else a
        var d = if (a < b) b else a
        while (d % c != 0) {
            val temp = c
            c = d % c
            d = temp
        }
        return Pair(a / c, b / c)
    }

    private fun toString(num: Pair<Int, Int>): String {
        val (numerator, denominator) = num
        return when (numerator % denominator) {
            0 -> "${numerator / denominator}"
            else -> "[$numerator, $denominator]"
        }
    }
}