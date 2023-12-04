package day01

import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class FirstLastPairTest {
    private lateinit var pair: FirstLastPair

    @BeforeEach
    fun setup() {
        pair = FirstLastPair()
    }

    @Test
    fun `when the pair is empty and one value is added, then first value should be that value`() {
        pair.addIfFirstOrLast(1, listOf(1))
        assertEquals(1, pair.firstValue())
        assertNull(pair.lastValue())
    }

    @Test
    fun `when the pair is empty, then should contain any added values`() {
        pair.addIfFirstOrLast(1, listOf(1))
        pair.addIfFirstOrLast(1, listOf(2))

        assertEquals(1, pair.firstValue())
        assertEquals(1, pair.lastValue())
    }

    @Test
    fun `when the pair is not empty, then should only replaces values when the index is higher or lower`() {
        val startingLowIndex = 3
        val startingHighIndex = 5
        pair.addIfFirstOrLast(1, listOf(startingLowIndex))
        pair.addIfFirstOrLast(2, listOf(startingHighIndex))

        pair.addIfFirstOrLast(3, listOf(startingLowIndex))
        pair.addIfFirstOrLast(4, listOf(startingHighIndex))
        pair.addIfFirstOrLast(5, listOf(startingLowIndex - 1))
        pair.addIfFirstOrLast(6, listOf(startingHighIndex + 1))

        assertEquals(5, pair.firstValue())
        assertEquals(6, pair.lastValue())
    }
}