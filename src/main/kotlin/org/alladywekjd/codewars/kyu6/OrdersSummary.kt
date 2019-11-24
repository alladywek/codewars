package org.alladywekjd.codewars.kyu6

import java.math.BigDecimal
import java.util.regex.Matcher

object OrdersSummary {

    sealed class Order {
        data class CorrectOrder(
                val quote: String,
                val quantity: Int,
                val price: BigDecimal,
                val totalPrice: BigDecimal,
                val status: String) : Order()

        data class IncorrectOrder(val src: String) : Order()
    }

    fun balanceStatements(lst: String): String {
        val (correctOrders, incorrectOrders) = lst
                .split(",\\s*".toRegex())
                .map(this::parseOrder)
                .partition {
                    when (it) {
                        is Order.CorrectOrder -> true
                        is Order.IncorrectOrder -> false
                    }
                }
        val buyPrice = getTotalPriceByStatus(correctOrders, "B")
        val sellPrice = getTotalPriceByStatus(correctOrders, "S")

        return "Buy: $buyPrice Sell: $sellPrice${buildIncorrectOrdersAsString(incorrectOrders)}"
    }

    private fun parseOrder(orderString: String): Order {
        val orderPattern = "(?<quote>(\\w|\\.)+)\\s(?<quantity>\\d+)\\s(?<price>\\d+\\.\\d+)\\s(?<status>[BS])".toPattern()
        val matcher = orderPattern.matcher(orderString)
        return if (matcher.matches()) {
            buildCorrectOrder(matcher)
        } else
            Order.IncorrectOrder(orderString)
    }

    private fun buildCorrectOrder(matcher: Matcher): Order.CorrectOrder {
        val quantity = matcher.group("quantity").toInt()
        val price = BigDecimal(matcher.group("price"))
        return Order.CorrectOrder(
                quote = matcher.group("quote"),
                quantity = quantity,
                price = price,
                totalPrice = price.multiply(BigDecimal(quantity)),
                status = matcher.group("status")
        )
    }

    private fun getTotalPriceByStatus(orders: List<Order>, status: String): String {
        val filteredOrders = orders
                .map { it as Order.CorrectOrder }
                .filter { it.status == status }
        return if (filteredOrders.isEmpty()) "0" else filteredOrders
                .map { it.totalPrice }
                .reduce { sum, orderTotalPrice -> sum.plus(orderTotalPrice) }
                .toBigInteger()
                .toString()
    }

    private fun buildIncorrectOrdersAsString(orders: List<Order>): String {
        return if (orders.isEmpty()) "" else
            orders
                    .map { it as Order.IncorrectOrder }
                    .joinToString(
                            prefix = "; Badly formed ${orders.size}: ",
                            separator = " ;",
                            postfix = " ;"
                    ) { it.src }
    }
}