package org.alladywek.kyu5

import kotlin.math.absoluteValue

/**
 * kata https://www.codewars.com/kata/573992c724fc289553000e95
 */
object ToSmallest {

    fun smallest(n: Long): LongArray {
        val initialNumberAsString = n.absoluteValue.toString()
        val variants = hashMapOf(initialNumberAsString to (0 to 0))

        initialNumberAsString.forEachIndexed { index, digit ->
            initialNumberAsString.indices.forEach { newIndex ->
                if (newIndex != index) {
                    val numberAsString = StringBuilder(initialNumberAsString)
                            .deleteCharAt(index)
                            .insert(newIndex, digit)
                            .toString()
                    variants[numberAsString]
                            ?.also { (prevIndex, _) ->
                                if (index < prevIndex) variants[numberAsString] = index to newIndex
                            }
                            ?: variants.put(numberAsString, index to newIndex)
                }
            }
        }
        val (minVariantNumberAsString, indices) = variants.minBy { (number, _) -> number }!!

        return longArrayOf(minVariantNumberAsString.toLong(), indices.first.toLong(), indices.second.toLong())
    }
}
