package day03

data class NumberData(
    val value: Int,
    val rowIndex: Int,
    val lineIndex: Int
)

data class SymbolData (
    val value: Char,
    val rowIndex: Int,
    val lineIndex: Int
)

data class FileData(
    val numberDatas: List<NumberData>,
    val symbolDatas: List<SymbolData>
)

class FileParser {
    fun parseFile(lines: List<String>): FileData {
        val numberDatas = mutableListOf<NumberData>()
        val symbolDatas = mutableListOf<SymbolData>()

        lines.forEachIndexed{ rowIndex, line ->
            val datas = parseLine(rowIndex, line)
            numberDatas += datas.first
            symbolDatas += datas.second
        }

        return FileData(numberDatas, symbolDatas)
    }

    private fun parseLine(rowIndex: Int, line: String): Pair<List<NumberData>, List<SymbolData>> {
        var symbolData = mutableListOf<SymbolData>()
        val numberData = mutableListOf<NumberData>()
        var numberString = ""
        var startIndex = -1

        line.forEachIndexed{ index, char ->
            if (char.isDigit()) {
                numberString += char
                if (startIndex == -1) {
                    startIndex = index
                }
            } else {
                if (startIndex != -1) {
                    numberData.add(NumberData(numberString.toInt(), rowIndex, startIndex))
                    numberString = ""
                    startIndex = -1
                }
                if (char != '.') {
                    symbolData.add(SymbolData(char, rowIndex, index))
                }
            }
        }

        if (startIndex != -1) {
            numberData.add(NumberData(numberString.toInt(), rowIndex, startIndex))
        }

        return Pair(numberData, symbolData)
    }
}