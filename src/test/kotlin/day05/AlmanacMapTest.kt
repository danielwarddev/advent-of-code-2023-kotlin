package day05

import kotlin.test.Test
import kotlin.test.assertEquals

class AlmanacMapTest {
    @Test
    fun `if value is not in the source range, returns null`() {
        val map = AlmanacMap(1, 5, 10)

        val actualValue = map.getMappedValue(11L)

        assertEquals(null, actualValue)
    }

    @Test
    fun `if value is within both ranges, returns the corresponding value in the destination range`() {
        val expectedValue = 8L
        val map = AlmanacMap(1, 5, 10)

        val actualValue = map.getMappedValue(4)

        assertEquals(expectedValue, actualValue)
    }
}