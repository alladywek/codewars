package org.alladywekjd.codewars.kyu6


import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode
import kotlin.math.PI
import kotlin.math.acos
import kotlin.math.sin
import kotlin.math.sqrt

/*
    To introduce the problem think to my neighbor who drives a tanker truck. The level indicator is down and he is worried
 because he does not know if he will be able to make deliveries. We put the truck on a horizontal ground and measured
 the height of the liquid in the tank.
    Fortunately the tank is a perfect cylinder and the vertical walls on each end are flat. The height of the remaining
 liquid is h, the diameter of the cylinder is d, the total volume is vt (h, d, vt are positive or null integers). You can assume that h <= d.
    Could you calculate the remaining volume of the liquid? Your function tankvol(h, d, vt) returns an integer which
 is the truncated result (e.g floor) of your float calculation.
    Examples:
 tankvol(40,120,3500) should return 1021 (calculation gives about: 1021.26992027)
 tankvol(60,120,3500) should return 1750
 tankvol(80,120,3500) should return 2478 (calculation gives about: 2478.73007973)
 */

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

fun main() {
    println(2940 == tankVol(5, 7, 3848))
    println(245 == tankVol(1, 4, 1256))
}