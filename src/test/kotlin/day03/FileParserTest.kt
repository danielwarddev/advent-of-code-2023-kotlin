package day03

import kotlin.test.Test
import kotlin.test.assertEquals

class FileParserTest {
    private val parser = FileParser()

    @Test
    fun `gets data about numbers and symbols from file`() {
        val fileLines = listOf(
            "467..114..",
            "...*......",
            "..35..633.",
            "......#...",
            "617*......"
        )
        val expectedNumberDatas = listOf(
            NumberData(467, 0, 0),
            NumberData(114, 0, 5),
            NumberData(35, 2, 2),
            NumberData(633, 2, 6),
            NumberData(617, 4, 0)
        )
        val expectedSymbolIndices = listOf(
            SymbolData('*', 1, 3),
            SymbolData('#', 3, 6),
            SymbolData('*', 4, 3)
        )
        val expectedData = FileData(expectedNumberDatas, expectedSymbolIndices)

        val actualData = parser.parseFile(fileLines)

        assertEquals(expectedData, actualData)
    }
}