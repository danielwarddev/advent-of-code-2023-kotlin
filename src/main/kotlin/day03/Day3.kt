package day03

import java.io.File

class Day3(
    val inputFilePath: String,
    val fileParser: FileParser,
    val partASolver: PartASolver,
    val partBSolver: PartBSolver
) {
    fun solveA(): Int {
        val fileLines = File(inputFilePath).useLines { it.toList() }
        val fileData = fileParser.parseFile(fileLines)
        return partASolver.solve(fileData)
    }

    fun solveB(): Int {
        val fileLines = File(inputFilePath).useLines { it.toList() }
        val fileData = fileParser.parseFile(fileLines)
        return partBSolver.solve(fileData)
    }
}