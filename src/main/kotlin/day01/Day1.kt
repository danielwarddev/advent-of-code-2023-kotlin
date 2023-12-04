package day01

import java.io.File

class Day1(
    private val inputFilePath: String,
    private val lineParser: LineParser,
) {
    fun solveA(): Int {
        return solve(true)
    }

    fun solveB(): Int {
        return solve(false)
    }

    private fun solve(numericDigitsOnly: Boolean): Int {
        var totalSum = 0

        File(inputFilePath).forEachLine {
            if (numericDigitsOnly) {
                totalSum += lineParser.getDigitOnlyCalibrationValue(it)
            } else {
                totalSum += lineParser.getWordAndDigitCalibrationValue(it)
            }
        }

        return totalSum
    }
}