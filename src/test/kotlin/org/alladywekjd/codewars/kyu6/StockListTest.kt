package org.alladywekjd.codewars.kyu6

import io.kotlintest.specs.StringSpec
import org.junit.jupiter.api.Assertions.assertEquals

class StockListTest : StringSpec() {

    private fun testing(lstOfArt: Array<String>, lstOfCat: Array<String>, expect: String) {
        val actual: String = StockList.stockSummary(lstOfArt, lstOfCat)
        assertEquals(expect, actual)
    }

    init {
        "stockSummary" {
            var b = arrayOf("BBAR 150", "CDXE 515", "BKWR 250", "BTSQ 890", "DRTY 600")
            var c = arrayOf("A", "B", "C", "D")
            var res = "(A : 0) - (B : 1290) - (C : 515) - (D : 600)"
            testing(b, c, res)

            b = arrayOf("ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600")
            c = arrayOf("A", "B")
            res = "(A : 200) - (B : 1140)"
            testing(b, c, res)
        }
    }
}