package day03

import org.example.AdventDay

class Day3(
    override val inputFilePath: String,
    private val fileParser: FileParser,
    private val partASolver: PartASolver,
    private val partBSolver: PartBSolver
): AdventDay(inputFilePath) {
    override fun solveA(): Long {
        val fileLines = getAllFilesLines()
        val fileData = fileParser.parseFile(fileLines)
        return partASolver.solve(fileData).toLong()
    }

    override fun solveB(): Long {
        val fileLines = getAllFilesLines()
        val fileData = fileParser.parseFile(fileLines)
        return partBSolver.solve(fileData).toLong()
    }
}