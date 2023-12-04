package day03

import kotlin.test.Test
import kotlin.test.assertEquals

class Day3Test {
    private val day = Day3(
        "src/test/kotlin/day03/testInput.txt",
        FileParser(),
        PartASolver(),
        PartBSolver()
    )

    @Test
    fun `solves part A correctly`() {
        val expectedResult = 4361
        val actualResult = day.solveA()
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `solves part B correctly`() {
        val expectedResult = 467835
        val actualResult = day.solveB()
        assertEquals(expectedResult, actualResult)
    }
}