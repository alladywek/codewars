package org.alladywekjd.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("Start App")

    longFun()

    println("Before Finish App")
    delay(10000)
    println("Finish App")
}

suspend fun longFun() = coroutineScope {
    (1..20).forEach { i ->
        launch { if (i == 10) runWithException(i) else run(i) }
    }
}

private fun runWithException(index: Int) {
    throw Exception("bla bla: $index")
}

private suspend fun run(index: Int) {
    delay(5000)
    println("Finished: $index")
}