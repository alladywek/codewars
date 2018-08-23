package org.alladywekjd.codewars.kyu1

class MineSweeper(map: String, nMines: Int) {

    private val mines = nMines
    private val board = map.lines().map(this::parseRow).toMutableList()

    fun solve(): String {
        while (!isResolved() && !isUnresolved()) {

        }
        return if (isUnresolved()) "?" else buildResultBoard(board)
    }

    private fun buildResultBoard(board: MutableList<MutableList<Cell>>): String {
        return board
                .joinToString(separator = "\n") { row ->
                    row.joinToString(separator = " ") { cell ->
                        when (cell) {
                            Cell.MINE -> ""
                            Cell.NUMBER -> "1"
                            else -> throw IllegalStateException("Can't build unresolved board")
                        }
                    }
                }
    }

    private fun parseRow(line: String): MutableList<Cell> {
        return line
                .split(" ")
                .map { sign ->
                    when {
                        sign == "?" -> Cell.UNKNOWN
                        sign.toIntOrNull()?.let { it in 0..8 } ?: false -> Cell.NUMBER
                        else -> throw IllegalArgumentException("Can't parse sign on board: $sign")
                    }
                }
                .toMutableList()
    }

    private fun isResolved() = board.all { row -> row.all { cell -> cell == Cell.MINE || cell == Cell.NUMBER } }
    private fun isUnresolved() = board.flatMap { it }.count { cell -> cell == Cell.UNKNOWN } < mines
}

enum class Cell {
    UNKNOWN, MINE, NUMBER
}

val board = """? ? ? ? ? ?
              |? ? ? ? ? ?
              |? ? ? 0 ? ?
              |? ? ? ? ? ?
              |? ? ? ? ? ?
              |0 0 0 ? ? ?""".trimMargin()


fun main(args: Array<String>) {
    val a = MineSweeper(board, 4)
    println()
}