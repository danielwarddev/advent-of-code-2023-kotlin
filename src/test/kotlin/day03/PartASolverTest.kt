package day03

import kotlin.test.Test
import kotlin.test.assertEquals

class PartASolverTest {
    val solver = PartASolver()

    @Test
    fun `sums up all numbers that are adjacent to symbols`() {
        val expectedResult = 467 + 35 + 633

        val numberDatas = listOf(
            NumberData(467, 0, 0),
            NumberData(114, 0, 5),
            NumberData(35, 2, 2),
            NumberData(633, 2, 2)
        )
        val symbolDatas = listOf(
            SymbolData('*', 1, 3),
            SymbolData('#', 3, 7)
        )
        val fileData = FileData(numberDatas, symbolDatas)

        val actualResult = solver.solve(fileData)

        assertEquals(expectedResult, actualResult)
    }
}