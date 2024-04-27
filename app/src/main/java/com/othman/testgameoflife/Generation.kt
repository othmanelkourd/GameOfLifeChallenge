package com.othman.testgameoflife

class Generation constructor(
    private val width: Int,
    private val height: Int
) {
    var data = Array(width) { BooleanArray(height) }

    fun buildNextGeneration() {
        val newGenerationData = Array(width) { BooleanArray(height) }
        for (x in 0 until width) {
            for (y in 0 until height) {
                val aliveNeighbors = countAliveNeighbors(x, y)
                newGenerationData[x][y] = when {
                    !data[x][y] && aliveNeighbors == 3 -> true
                    data[x][y] && aliveNeighbors in 2..3 -> true
                    else -> false
                }
            }
        }
        data = newGenerationData
    }

    private fun countAliveNeighbors(x: Int, y: Int): Int {
        var count = 0
        for (i in -1..1) {
            for (j in -1..1) {
                val neighborX = x + i
                val neighborY = y + j
                if ((i != 0 || j != 0) // to avoid counting the actual cell
                    && neighborX in 0 until width  // to avoid index out of range
                    && neighborY in 0 until height
                ) {  // to avoid index out of rang
                    if (data[neighborX][neighborY]) {
                        count++
                    }
                }
            }
        }
        return count
    }

    fun setCellState(x: Int, y: Int, state: Boolean) {
        data[x][y] = state
    }

    fun print() {
        for (y in 0 until height) { // columns
            for (x in 0 until width) { // lines
                print(if (data[x][y]) "* " else ". ")
            }
            println()
        }
    }
}