package org.alladywekjd.codewars.kyu6

import java.math.BigDecimal

object OrdersSummary {

    fun balanceStatements(lst: String): String {
        val orderPattern = "(?<quote>(\\w|\\.)+)\\s(?<quantity>\\d+)\\s(?<price>\\d+\\.\\d+)\\s(?<status>[BS])".toPattern()

        var buyPrice = BigDecimal.ZERO
        var sellPrice = BigDecimal.ZERO
        val badOrders = mutableListOf<String>()
        for (orderString in lst.split(",\\s".toRegex())) {
            val matcher = orderPattern.matcher(orderString)
            if (matcher.matches()) {
                if (matcher.group("status") == "B")
                    buyPrice = buyPrice.plus(BigDecimal(matcher.group("price")).multiply(BigDecimal(matcher.group("quantity").toInt())))
                if (matcher.group("status") == "S")
                    sellPrice = sellPrice.plus(BigDecimal(matcher.group("price")).multiply(BigDecimal(matcher.group("quantity").toInt())))
            } else {
                if (orderString.trim().isNotEmpty()) {
                    badOrders.add("$orderString ;")
                }
            }
        }
        val badOrdersString = if (badOrders.isEmpty()) "" else badOrders.joinToString(
                prefix = "; Badly formed ${badOrders.size}: ",
                separator = ""
        )

        return "Buy: ${buyPrice.toBigInteger()} Sell: ${sellPrice.toBigInteger()}${badOrdersString}"
    }
}