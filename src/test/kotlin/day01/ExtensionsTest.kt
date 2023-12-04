package day01

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class ExtensionsTest {
    @ParameterizedTest
    @MethodSource("allIndicesOfCases")
    fun `returns all starting indices of a string in a string`(
        stringToSearch: String,
        stringToFind: String,
        expectedIndices: List<Int>
    ) {
        val actualIndices = stringToSearch.allIndicesOf(stringToFind)
        assertEquals(expectedIndices, actualIndices)
    }

    companion object {
        @JvmStatic
        fun allIndicesOfCases() = listOf(
            Arguments.of("dog catdog mouse dodog", "dog", listOf(0,7, 19)),
            Arguments.of("ajbc a j", "a", listOf(0,5)),
            Arguments.of("something", "dog", listOf<Int>())
        )
    }
}