package org.alladywek.kyu6

import io.kotlintest.specs.StringSpec
import org.alladywek.kyu6.SupermarketQueue.solveSuperMarketQueue
import org.junit.jupiter.api.Assertions.assertEquals


class SupermarketQueueTest : StringSpec() {

    init {
        "test normal condition" {
            assertEquals(9, solveSuperMarketQueue(intArrayOf(1, 2, 3, 4, 5), 2))
            assertEquals(9, solveSuperMarketQueue(intArrayOf(2, 2, 3, 3, 4, 4), 2))
            assertEquals(30, solveSuperMarketQueue(intArrayOf(4, 1, 2, 3, 7, 7, 5, 2, 2, 4, 5, 6, 5, 7, 1, 1, 4, 3, 7, 3, 1, 2), 3))
        }
        "test empty array" {
            assertEquals(0, solveSuperMarketQueue(intArrayOf(), 1));
        }
        "test single till many customers" {
            assertEquals(15, solveSuperMarketQueue(intArrayOf(1, 2, 3, 4, 5), 1))
        }
        "test customers less then tills" {
            assertEquals(3, solveSuperMarketQueue(intArrayOf(1, 2, 3), 5))
            assertEquals(5, solveSuperMarketQueue(intArrayOf(1, 2, 3, 5, 1), 5))
        }
    }
}