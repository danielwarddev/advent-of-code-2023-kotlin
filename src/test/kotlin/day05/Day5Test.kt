package day05

import kotlin.test.Test

class Day5Test {
    private val day = Day5(
        "src/test/kotlin/day05/testInput.txt",
        FileParser(),
        PartASolver()
    )

    @Test
    fun `solves part A correctly`() {
        val expectedResult = 35L
        val actualResult = day.solveA()
        kotlin.test.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `solves part B correctly`() {
        val expectedResult = 46L
        val actualResult = day.solveB()
        kotlin.test.assertEquals(expectedResult, actualResult)
    }
}