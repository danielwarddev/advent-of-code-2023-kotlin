package day04

import kotlin.test.Test

class Day4Test {
    private val day = Day4(
        "src/test/kotlin/day04/testInput.txt",
        LineParser(),
        PartASolver(),
        PartBSolver()
    )

    @Test
    fun `solves part A correctly`() {
        val expectedResult = 13L
        val actualResult = day.solveA()
        kotlin.test.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `solves part B correctly`() {
        val expectedResult = 30L
        val actualResult = day.solveB()
        kotlin.test.assertEquals(expectedResult, actualResult)
    }
}