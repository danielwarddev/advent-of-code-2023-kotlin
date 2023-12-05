package day01

import org.example.AdventDay

class Day1(
    override val inputFilePath: String,
    private val lineParser: LineParser,
): AdventDay(inputFilePath) {
    override fun solveA(): Int {
        return solve(true)
    }

    override fun solveB(): Int {
        return solve(false)
    }

    private fun solve(numericDigitsOnly: Boolean): Int {
        var totalSum = 0

        forEachFileLine {
            if (numericDigitsOnly) {
                totalSum += lineParser.getDigitOnlyCalibrationValue(it)
            } else {
                totalSum += lineParser.getWordAndDigitCalibrationValue(it)
            }
        }

        return totalSum
    }
}