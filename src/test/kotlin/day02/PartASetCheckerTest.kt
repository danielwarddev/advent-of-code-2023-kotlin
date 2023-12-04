package day02

import io.mockk.every
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class PartASetCheckerTest {
    private val checker = PartASetChecker()

    @Test
    fun `if sets contain at most 12 red, 13 green, and 14 blue cubes, then returns the game id`() {
        val cubeSets = listOf(
            listOf(
                CubeCount("red", 12),
                CubeCount("blue", 14)
            ),
            listOf(
                CubeCount("green", 13),
                CubeCount("blue", 1)
            ),
            listOf(
                CubeCount("red", 1),
                CubeCount("green", 2),
                CubeCount("blue", 3),
            )
        )

        val expectedId = 1
        val actualId = checker.checkSet(expectedId, cubeSets)
        kotlin.test.assertEquals(expectedId, actualId)
    }

    @ParameterizedTest
    @MethodSource("invalidSetCases")
    fun `if any set contains more than either 12 red, 13 green, or 14 blue cubes, then returns 0`(setCounts: List<List<CubeCount>>) {
        val actualId = checker.checkSet(1, setCounts)
        kotlin.test.assertEquals(0, actualId)
    }

    companion object {
        @JvmStatic
        fun invalidSetCases() = listOf(
            listOf(
                listOf(
                    CubeCount("red", 13),
                    CubeCount("green", 1),
                    CubeCount("blue", 1),
                ),
                listOf(
                    CubeCount("red", 1),
                    CubeCount("green", 14),
                    CubeCount("blue", 1),
                ),
                listOf(
                    CubeCount("red", 1),
                    CubeCount("green", 1),
                    CubeCount("blue", 14),
                )
            )
        )
    }
}