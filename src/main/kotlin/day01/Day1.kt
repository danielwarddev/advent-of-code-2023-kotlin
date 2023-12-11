package day01

import org.example.AdventDay

class Day1(
    override val inputFilePath: String,
    private val lineParser: LineParser,
): AdventDay(inputFilePath) {
    override fun solveA(): Long {
        return solve(true).toLong()
    }

    override fun solveB(): Long {
        return solve(false).toLong()
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