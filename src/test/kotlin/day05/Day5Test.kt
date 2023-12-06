package day05

import kotlin.test.Test

class Day5Test {
    val day = Day5("src/test/kotlin/day05/testInput.txt",)

    @Test
    fun `solves part A correctly`() {
        val expectedResult = 13
        val actualResult = day.solveA()
        kotlin.test.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `solves part B correctly`() {
        val expectedResult = 13
        val actualResult = day.solveA()
        kotlin.test.assertEquals(expectedResult, actualResult)
    }
}