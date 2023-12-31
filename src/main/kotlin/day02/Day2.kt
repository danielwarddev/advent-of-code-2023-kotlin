package day02

import org.example.AdventDay

class Day2(
    override val inputFilePath: String,
    private val lineParser: LineParser,
    private val partASetChecker: PartASetChecker,
    private val partBSetChecker: PartBSetChecker
): AdventDay(inputFilePath) {
    override fun solveA(): Long {
        return solve(partASetChecker).toLong()
    }

    override fun solveB(): Long {
        return solve(partBSetChecker).toLong()
    }

    private fun solve(setChecker: SetChecker): Int {
        var totalSum = 0

        forEachFileLine {
            totalSum += lineParser.parseLine(it, setChecker)
        }

        return totalSum
    }
}