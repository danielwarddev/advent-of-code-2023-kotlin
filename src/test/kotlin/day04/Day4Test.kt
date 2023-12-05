package day04

import org.junit.jupiter.api.Test

class Day4Test {
    private val day = Day4(
        "src/test/kotlin/day04/testInput.txt",
        LineParser(),
        PartASolver(),
        PartBSolver()
    )

    @Test
    fun solveA() {
        val expectedResult = 13
        val actualResult = day.solveA()
        kotlin.test.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun solveB() {
        val expectedResult = 30
        val actualResult = day.solveB()
        kotlin.test.assertEquals(expectedResult, actualResult)
    }
}