package org.alladywek.kyu5

import java.util.*

fun josephusSurvivor(n: Int, k: Int): Int {
    val list = ArrayList<Int>(n)
    repeat(n) { index -> list.add(index + 1) }
    var step = 1
    var index = 0
    while (list.size > 1) {
        if (step.rem(k) == 0) {
            list.removeAt(index)
            step = 1
            index = if (list.lastIndex >= index) index else 0
        } else {
            step++
            index = if (list.lastIndex > index) index + 1 else 0
        }
    }
    return list[0]
}