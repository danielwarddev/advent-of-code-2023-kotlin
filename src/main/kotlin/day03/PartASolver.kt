package day03

class PartASolver {
    fun solve(fileData: FileData): Int {
        var totalSum = 0;

        for(numberData in fileData.numberDatas) {
            val adjacentRowIndices = listOf(
                numberData.rowIndex -1,
                numberData.rowIndex,
                numberData.rowIndex + 1
            )
            val numberLength = numberData.value.toString().length
            val adjacentLineIndices = (numberData.lineIndex - 1)
                .rangeTo(numberData.lineIndex + numberLength)

            val anyAdjacentSymbols = fileData.symbolDatas.any {
                adjacentRowIndices.contains(it.rowIndex) &&
                adjacentLineIndices.contains(it.lineIndex)
            }

            if (anyAdjacentSymbols) {
                totalSum += numberData.value
            }
        }

        return totalSum
    }
}
