package day01

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class FileParserTest {
    private val parser = LineParser()

    @ParameterizedTest
    @MethodSource("numericOrWordTwoDigitCases")
    fun `returns the first numeric or word digit and the last numeric or word digit in the string as a number`(line: String, expectedResult: Int) {
        val actualResult = parser.getWordAndDigitCalibrationValue(line)
        assertEquals(expectedResult, actualResult)
    }

    @ParameterizedTest
    @MethodSource("numericOrWordOneDigitCases")
    fun `uses the lone numeric or word digit twice if there is only one numeric digit in the string`(line: String, expectedResult: Int) {
        val actualResult = parser.getWordAndDigitCalibrationValue(line)
        assertEquals(expectedResult, actualResult)
    }

    @ParameterizedTest
    @MethodSource("numericOrWordZeroDigitCases")
    fun `throws when there are no numeric or word digits in the line`(line: String) {
        assertFailsWith<Exception>("No digits found line: $line") {
            parser.getWordAndDigitCalibrationValue(line)
        }
    }

    @ParameterizedTest
    @MethodSource("numericOnlyTwoDigitCases")
    fun `returns the first numeric digit and the last numeric or word digit in the string as a number`(line: String, expectedResult: Int) {
        val actualResult = parser.getDigitOnlyCalibrationValue(line)
        assertEquals(expectedResult, actualResult)
    }

    @ParameterizedTest
    @MethodSource("numericOnlyOneDigitCases")
    fun `uses the lone numeric digit twice if there is only one numeric digit in the string`(line: String, expectedResult: Int) {
        val actualResult = parser.getDigitOnlyCalibrationValue(line)
        assertEquals(expectedResult, actualResult)
    }

    @ParameterizedTest
    @MethodSource("numericOnlyZeroDigitCases")
    fun `throws when there are no numeric digits in the line`(line: String) {
        assertFailsWith<Exception>("No digits found line: $line") {
            parser.getDigitOnlyCalibrationValue(line)
        }
    }

    companion object {
        @JvmStatic
        fun numericOrWordTwoDigitCases() = listOf(
            Arguments.of("12", 12),
            Arguments.of("jfj3n5ecb7one", 31),
            Arguments.of("sdkj8,fdtwo1k 3foursd5", 85),
            Arguments.of("htwodh94jv5jf6", 26),
        )

        @JvmStatic
        fun numericOrWordOneDigitCases() = listOf(
            Arguments.of("1", 11),
            Arguments.of("sdf5df", 55),
            Arguments.of("on,  two", 22),
        )

        @JvmStatic
        fun numericOrWordZeroDigitCases() = listOf(
            Arguments.of("a"),
            Arguments.of("sdfidf"),
            Arguments.of("on, dfs tow"),
        )

        @JvmStatic
        fun numericOnlyTwoDigitCases() = listOf(
            Arguments.of("12", 12),
            Arguments.of("jfj3ntwo5ecb7", 37),
            Arguments.of("sdkj8,fdtwo1k 3fsdone", 83),
            Arguments.of("hdh94jv5jf6", 96),
        )

        @JvmStatic
        fun numericOnlyOneDigitCases() = listOf(
            Arguments.of("1", 11),
            Arguments.of("sdf5df", 55),
            Arguments.of("one3,  two", 33),
        )

        @JvmStatic
        fun numericOnlyZeroDigitCases() = listOf(
            Arguments.of("a"),
            Arguments.of("sdfidf"),
            Arguments.of("one,  two"),
        )
    }
}