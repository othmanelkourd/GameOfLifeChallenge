package com.othman.testgameoflife

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class GenerationTest {


    @Test
    fun checkNextGeneration() {
        /**
         * Generation:
         *  . . . . . . . . . .
         *  . . . * * . . . . .
         *  . . . . * . . . . .
         *  . . . . . . . . . .
         *  . . . . . . . . . .
         */

        val generation = Generation(10, 5)
        generation.setCellState(3, 1, true)
        generation.setCellState(4, 1, true)
        generation.setCellState(4, 2, true)

        /**
        * Expected:
        *  . . . . . . . . . .
        *  . . . * * . . . . .
        *  . . . * * . . . . .
        *  . . . . . . . . . .
        *  . . . . . . . . . .
        */

        val expected = Generation(10, 5)
        expected.setCellState(3, 1, true)
        expected.setCellState(4, 1, true)
        expected.setCellState(3, 2, true)
        expected.setCellState(4, 2, true)

        generation.buildNextGeneration()

        assertArrayEquals(expected.data, generation.data)
    }
}