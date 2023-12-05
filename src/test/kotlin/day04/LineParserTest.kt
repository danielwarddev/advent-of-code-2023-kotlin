package day04

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class LineParserTest {
    private val parser = LineParser()

    @ParameterizedTest
    @MethodSource("cardLines")
    fun `correctly parses the game number and numbers on a card`(line: String, expectedValue: CardData) {
        val actualValue = parser.parseNumbersForCards(line)
        assertEquals(expectedValue, actualValue)
    }

    companion object {
        @JvmStatic
        fun cardLines() = listOf(
            Arguments.of(
                "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53",
                CardData(1, 4)
            ),
            Arguments.of(
                "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19",
                CardData(2, 2)
            ),
            Arguments.of(
                "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1",
                CardData(3, 2)
            ),
            Arguments.of(
                "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83",
                CardData(4, 1)
            ),
            Arguments.of(
                "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36",
                CardData(5, 0)
            ),
            Arguments.of(
                "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11",
                CardData(6, 0)
            ),
        )
    }
}