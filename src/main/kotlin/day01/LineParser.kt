package day01

 class LineParser {
    private val numbersWords = listOf(
        "zero", "one", "two", "three", "four",
        "five", "six", "seven", "eight", "nine"
    )
    private val numberDigits = listOf(
        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
    )
    private fun wordToNumberMap(word: String): Int {
        return when(word) {
            "0", "zero" -> 0
            "1", "one" -> 1
            "2", "two" -> 2
            "3", "three" -> 3
            "4", "four" -> 4
            "5", "five" -> 5
            "6", "six" -> 6
            "7", "seven" -> 7
            "8", "eight" -> 8
            "9", "nine" -> 9
            else -> throw Exception("Unrecognized number string")
        }
    }

    fun getDigitOnlyCalibrationValue(line: String): Int {
        return getCalibrationValue(line, numberDigits)
    }

    fun getWordAndDigitCalibrationValue(line: String): Int {
        return getCalibrationValue(line, numberDigits + numbersWords)
    }

    private fun getCalibrationValue(line: String, words: List<String>): Int {
        val pair = findFirstAndLastValues(line, words)

        if (pair.lastValue() == null) {
            if (pair.firstValue() == null) {
                throw Exception("No digits found in line: $line")
            } else {
                return "${pair.firstValue()}${pair.firstValue()}".toInt()
            }
        }

        return "${pair.firstValue()}${pair.lastValue()}".toInt()
    }

    private fun findFirstAndLastValues(line: String, words: List<String>): FirstLastPair {
        val firstLastPair = FirstLastPair()

        for(word in words) {
            val wordIndices = line.allIndicesOf(word)
            val numberValue = wordToNumberMap(word)
            firstLastPair.addIfFirstOrLast(numberValue, wordIndices)
        }

        return firstLastPair
    }
}