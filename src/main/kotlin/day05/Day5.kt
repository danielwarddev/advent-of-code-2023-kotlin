package day05

import org.example.AdventDay

class Day5(
    override val inputFilePath: String,
    private val fileParser: FileParser,
    private val partASolver: PartASolver
): AdventDay(inputFilePath) {
    override fun solveA(): Long {
        val fileLines = getAllFilesLines()
        val almanac = fileParser.parse(fileLines)
        val seedLocations = partASolver.solve(almanac)
        return seedLocations.map { it.value }.min()
    }

    override fun solveB(): Long {
        TODO("Not yet implemented")
    }
}