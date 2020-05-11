package org.alladywek.kyu6

object StockList {

    fun stockSummary(lstOfArt: Array<String>, lstOfCat: Array<String>): String {
        val repository = lstOfArt.groupBy({ stock -> stock[0].toString() }, { stock -> stock.split(" ")[1].toInt() })
        return lstOfCat.joinToString(" - ") { category -> "($category : ${repository[category]?.sum() ?: 0})" }
    }
}