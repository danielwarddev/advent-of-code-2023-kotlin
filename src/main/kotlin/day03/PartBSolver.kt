package day03

class PartBSolver {
    fun solve(fileData: FileData): Int {
        var totalSum = 0;

        for(symbolData in fileData.symbolDatas.filter { it.value == '*' }) {
            val adjacentRowIndices = listOf(
                symbolData.rowIndex -1,
                symbolData.rowIndex,
                symbolData.rowIndex + 1
            )
            val adjacentLineIndices = listOf(
                symbolData.lineIndex - 1,
                symbolData.lineIndex,
                symbolData.lineIndex + 1
            )

            val adjacentNumbers = fileData.numberDatas
                .filter {
                    adjacentRowIndices.contains(it.rowIndex)
                }.filter {
                    val numberLength = it.value.toString().length
                    val validLineIndices = (it.lineIndex)
                        .rangeTo(it.lineIndex + numberLength - 1)
                    adjacentLineIndices.intersect(validLineIndices).any()
            }

            if (adjacentNumbers.size == 2) {
                totalSum += (adjacentNumbers[0].value * adjacentNumbers[1].value)
            }
        }

        return totalSum
    }
}