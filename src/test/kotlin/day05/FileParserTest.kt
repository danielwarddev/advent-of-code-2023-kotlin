package day05

import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals

class FileParserTest {
    private val parser = FileParser()

    @Test
    fun `parses file into almanac data correctly`() {
        val expectedValue = AlmanacData(
            seeds = listOf(79, 14, 55, 13),
            seedToSoilMaps = listOf(
                AlmanacMap(98, 50, 2),
                AlmanacMap(50, 52, 48)
            ),
            soilToFertilizerMaps = listOf(
                AlmanacMap(15, 0, 37),
                AlmanacMap(52, 37, 2),
                AlmanacMap(0, 39, 15)
            ),
            fertilizerToWaterMaps = listOf(
                AlmanacMap(53, 49, 8),
                AlmanacMap(11, 0, 42),
                AlmanacMap(0, 42, 7),
                AlmanacMap(7, 57, 4)
            ),
            waterToLightMaps = listOf(
                AlmanacMap(18, 88, 7),
                AlmanacMap(25, 18, 70)
            ),
            lightToTemperatureMaps = listOf(
                AlmanacMap(77, 45, 23),
                AlmanacMap(45, 81, 19),
                AlmanacMap(64, 68, 13)
            ),
            temperatureToHumidityMaps = listOf(
                AlmanacMap(69, 0, 1),
                AlmanacMap(0, 1, 69)
            ),
            humidityToLocationMaps = listOf(
                AlmanacMap(56, 60, 37),
                AlmanacMap(93, 56, 4)
            )
        )
        val fileLines = File("src/test/kotlin/day05/testInput.txt").useLines { it.toList() }

        val actualValue = parser.parse(fileLines)

        assertEquals(expectedValue, actualValue)
    }
}