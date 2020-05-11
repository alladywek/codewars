package org.alladywek.kyu6

fun hist(s: String): String {
    return s.filter { it in "uwxz" }
            .groupBy { it }
            .map { (error, list) -> "$error  ${list.size.toString().padEnd(6)}${"*".repeat(list.size)}" }
            .sorted()
            .joinToString("\r") { it }
}