package com.othman.testgameoflife

fun main() {
    val game = Generation(10, 5)
    game.setCellState(3, 1, true)
    game.setCellState(4, 1, true)
    game.setCellState(4, 2, true)


    repeat(5) {
        println("Generation ${it + 1}:")
        game.print()
        game.buildNextGeneration()
    }
}
