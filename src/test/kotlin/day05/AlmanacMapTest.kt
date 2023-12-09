package day05

import kotlin.math.exp
import kotlin.test.Test
import kotlin.test.assertEquals

class AlmanacMapTest {
    @Test
    fun `if value is not in the source range, returns the value`() {
        val expectedValue = 11L
        val map = AlmanacMap(1, 5, 10)

        val actualValue = map.getMappedValue(expectedValue)

        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `if value is not in the destination range, returns the value`() {
        val expectedValue = 11L
        val map = AlmanacMap(5, 1, 10)

        val actualValue = map.getMappedValue(expectedValue)

        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `if value is within both ranges, returns the corresponding value in the destination range`() {
        val expectedValue = 8L
        val map = AlmanacMap(1, 5, 10)

        val actualValue = map.getMappedValue(4)

        assertEquals(expectedValue, actualValue)
    }
}