package org.alladywekjd.codewars.kyu6


import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode
import kotlin.math.*

val mathContext = MathContext(16, RoundingMode.HALF_UP)

fun tankVol(h: Int, d: Int, vt: Int): Int {
    val height = h.toBigDecimal()
    val diameter = d.toBigDecimal()
    val radius = diameter.multiply(BigDecimal("0.5"), mathContext)
    println("radius = $radius")
    val square = radius.pow(2, mathContext).multiply(BigDecimal(PI), mathContext)
    println("square = $square")
    val deep = BigDecimal(vt).divide(square, mathContext)
    println("deep = $deep")
    return when {
        height.compareTo(diameter) == 0 -> {
            println("h == diameter")
            square.multiply(deep, mathContext)
        }
        height.compareTo(radius) == 0 -> {
            println("h == radius")
            square.divide(BigDecimal(2), mathContext).multiply(deep, mathContext)
        }
        height < radius -> {
            println("h < radius")
            segment(radius, height).multiply(deep, mathContext)
        }
        else -> {
            println("h > radius")
            square.subtract(segment(radius, diameter - height)).multiply(deep)
        }
    }.toInt()
}

private fun segment(radius: BigDecimal, segmentHeight: BigDecimal): BigDecimal {
    println("segmentHeight = $segmentHeight")
    val base = sqrt(radius.pow(2, mathContext).subtract(radius.subtract(segmentHeight).pow(2)).toDouble()).toBigDecimal(mathContext)
    println("base = $base")
    val aSquare = base.pow(2, mathContext)
    println("a^2 = $aSquare")
    val bSquare = radius.subtract(segmentHeight).pow(2, mathContext)
    println("b^2 = $bSquare")
    val cSquare = radius.pow(2, mathContext)
    println("c^2 = $cSquare")
    val divider = (radius.subtract(segmentHeight)).multiply(radius.multiply(BigDecimal(2), mathContext), mathContext)
    println("divideer = $divider")
    val angleRadians = acos(bSquare.add(cSquare).subtract(aSquare).divide(divider, mathContext).toDouble()).toBigDecimal(mathContext)
    println("angle radians = $angleRadians")
    val segmentSquare = (angleRadians.multiply(BigDecimal(2), mathContext).subtract(sin(angleRadians.multiply(BigDecimal(2), mathContext).toDouble()).toBigDecimal())).multiply(radius.pow(2, mathContext).divide(BigDecimal(2), mathContext))
    println("segment square = $segmentSquare")
    return segmentSquare
}

fun main(args: Array<String>) {
    println(2940 == tankVol(5, 7, 3848))
    println(245 == tankVol(1, 4, 1256))
}