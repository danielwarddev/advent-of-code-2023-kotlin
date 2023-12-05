package day04

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class PartASolverTest {
    private val solver = PartASolver()

    @ParameterizedTest
    @MethodSource("cardLines")
    fun `calculates the correct value for card numbers`(matchingNumberCount: Int, expectedValue: Int) {
        val actualValue = solver.solve(matchingNumberCount)
        assertEquals(expectedValue, actualValue)
    }

    companion object {
        @JvmStatic
        fun cardLines() = listOf(
            Arguments.of(0, 0),
            Arguments.of(1, 1),
            Arguments.of(2, 2),
            Arguments.of(3, 4),
            Arguments.of(4, 8)
        )
    }
}