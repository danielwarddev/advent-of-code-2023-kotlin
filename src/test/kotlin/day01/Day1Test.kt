package day01

import kotlin.test.Test
import kotlin.test.assertEquals

class Day1Test {
    @Test
    fun `solves part A correctly`() {
        val day = createDay("src/test/kotlin/day01/testInputA.txt")
        val expectedSum = 142

        val actualSum = day.solveA()

        assertEquals(expectedSum, actualSum)
    }

    @Test
    fun `solves part B correctly`() {
        val day = createDay("src/test/kotlin/day01/testInputB.txt")
        val expectedSum = 281

        val actualSum = day.solveB()

        assertEquals(expectedSum, actualSum)
    }

    private fun createDay(inputFilePath: String): Day1 {
        return Day1(
            inputFilePath,
            LineParser()
        )
    }
}