package day04

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class PartBSolverTest {
    private val solver = PartBSolver()
    private val cardPiles = listOf(
        CardData(1, 4),
        CardData(2, 2),
        CardData(3, 2),
        CardData(4, 1),
        CardData(5, 0),
        CardData(6, 0),
    )

    @ParameterizedTest
    @MethodSource("cardPiles")
    fun `calculates the correct value for the pile of cards`(numberOfCardPilesToInclude: Int, expectedVaule: Int) {
        val cardPilesToUse = cardPiles.subList(0, numberOfCardPilesToInclude)
        val actualValue = solver.solve(cardPilesToUse)
        assertEquals(expectedVaule, actualValue)
    }

    companion object {
        @JvmStatic
        fun cardPiles() = listOf(
            Arguments.of(1, 1),
            Arguments.of(2, 1 + 2),
            Arguments.of(3, 1 + 2 + 4),
            Arguments.of(4, 1 + 2 + 4 + 8),
            Arguments.of(5, 1 + 2 + 4 + 8 + 14),
            Arguments.of(6, 1 + 2 + 4 + 8 + 14 + 1)
        )
    }
}