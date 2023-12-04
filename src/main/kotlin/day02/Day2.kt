package day02

import java.io.File

class Day2(
    private val inputFilePath: String,
    private val lineParser: LineParser,
    private val partASetChecker: PartASetChecker,
    private val partBSetChecker: PartBSetChecker
) {
    fun solveA(): Int {
        return solve(partASetChecker)
    }

    fun solveB(): Int {
        return solve(partBSetChecker)
    }

    private fun solve(setChecker: SetChecker): Int {
        var totalSum = 0

        File(inputFilePath).forEachLine {
            totalSum += lineParser.parseLine(it, setChecker)
        }

        return totalSum
    }
}