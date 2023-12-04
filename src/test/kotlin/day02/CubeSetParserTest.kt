package day02

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class CubeSetParserTest {
    private val parser = CubeSetParser()

    @Test
    fun `gets correct cube counts from sets line`() {
        val expectedSetCounts = listOf(
            listOf(
                CubeCount("blue", 13),
                CubeCount("red", 4)
            ),
            listOf(
                CubeCount("red", 1),
                CubeCount("green", 2),
                CubeCount("blue", 6),
            ),
            listOf(
                CubeCount("green", 2)
            )
        )

        val actualSetCounts = parser.parseLine("13 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")

        assertContentEquals(expectedSetCounts, actualSetCounts)
    }
}