package day02

import kotlin.test.Test

class PartBSetCheckerTest {
    private val checker = PartBSetChecker()

    @Test
    fun `returns the minimum number of each color required for set multiplied together`() {
        val cubeSets = listOf(
            listOf(
                CubeCount("red", 1),
                CubeCount("blue", 5)
            ),
            listOf(
                CubeCount("green", 7),
                CubeCount("blue", 2)
            ),
            listOf(
                CubeCount("red", 3),
                CubeCount("green", 2),
                CubeCount("blue", 3),
            )
        )

        val expectedResult = 3 * 7 * 5
        val actualResult = checker.checkSet(1, cubeSets)
        kotlin.test.assertEquals(expectedResult, actualResult)
    }
}