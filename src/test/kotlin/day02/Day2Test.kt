package day02

import kotlin.test.Test
import kotlin.test.assertEquals

class Day2Test {
    private val day2 = Day2(
        "src/test/kotlin/day02/testInputA.txt",
        LineParser(CubeSetParser(), GameIdParser()),
        PartASetChecker(),
        PartBSetChecker()
    )

    @Test
    fun `solves part A correctly`() {
        val expectedSum = 8
        val actualSum = day2.solveA()
        assertEquals(expectedSum, actualSum)
    }

    @Test
    fun `solves part B correctly`() {
        val expectedSum = 2286
        val actualSum = day2.solveB()
        assertEquals(expectedSum, actualSum)
    }
}