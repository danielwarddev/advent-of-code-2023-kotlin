package day05

import kotlin.test.Test
import kotlin.test.assertEquals

class PartASolverTest {
    private val solver = PartASolver()

    @Test
    fun `gets correct mapped seed values from almanac`() {
        val almanacData = AlmanacData(
            seedsRanges = listOf(
                SeedRange(79, 1),
                SeedRange(14, 1),
                SeedRange(55, 1),
                SeedRange(13, 1)
            ),
            listOf(
                listOf(
                    AlmanacMap(98, 50, 2),
                    AlmanacMap(50, 52, 48)
                ),
                listOf(
                    AlmanacMap(15, 0, 37),
                    AlmanacMap(52, 37, 2),
                    AlmanacMap(0, 39, 15)
                ),
                listOf(
                    AlmanacMap(53, 49, 8),
                    AlmanacMap(11, 0, 42),
                    AlmanacMap(0, 42, 7),
                    AlmanacMap(7, 57, 4)
                ),
                listOf(
                    AlmanacMap(18, 88, 7),
                    AlmanacMap(25, 18, 70)
                ),
                listOf(
                    AlmanacMap(77, 45, 23),
                    AlmanacMap(45, 81, 19),
                    AlmanacMap(64, 68, 13)
                ),
                listOf(
                    AlmanacMap(69, 0, 1),
                    AlmanacMap(0, 1, 69)
                ),
                listOf(
                    AlmanacMap(56, 60, 37),
                    AlmanacMap(93, 56, 4)
                )
            )
        )
        val expectedMappedValues = mapOf(
            79L to 82L,
            14L to 43L,
            55L to 86L,
            13L to 35L
        )

        val actualMappedValues = solver.solve(almanacData)

        assertEquals(expectedMappedValues, actualMappedValues)
    }
}