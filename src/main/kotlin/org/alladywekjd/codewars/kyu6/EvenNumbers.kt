package org.alladywekjd.codewars.kyu6

fun evenNumbers(array: List<Int>, number: Int): List<Int> {
    return array.filter { it.rem(2) == 0 }.takeLast(number)
}