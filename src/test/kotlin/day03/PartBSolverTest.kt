package day03

import kotlin.test.Test
import kotlin.test.assertEquals

class PartBSolverTest {
    private val solver = PartBSolver()

    @Test
    fun `sums all gear ratios together that are next to exactly two part numbers`() {
        val expectedResult = (467 * 35) + (617 * 123)

        val numberDatas = listOf(
            NumberData(467, 0, 0),
            NumberData(114, 0, 5),
            NumberData(35, 2, 2),
            NumberData(633, 2, 6),
            NumberData(617, 4, 0),
            NumberData(123, 4, 4)
        )
        val symbolDatas = listOf(
            SymbolData('*', 1, 3),
            SymbolData('#', 3, 7),
            SymbolData('*', 4, 3),
        )
        val fileData = FileData(numberDatas, symbolDatas)

        val actualResult = solver.solve(fileData)

        assertEquals(expectedResult, actualResult)
    }
}