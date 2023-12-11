package day04

import org.example.AdventDay

class Day4(
    override val inputFilePath: String,
    private val lineParser: LineParser,
    private val partASolver: PartASolver,
    private val partBSolver: PartBSolver
): AdventDay(inputFilePath) {
    override fun solveA(): Long {
        var totalPoints = 0

        forEachFileLine {
            val cardData = lineParser.parseNumbersForCards(it)
            totalPoints += partASolver.solve(cardData.matchingNumbersCount)
        }

        return totalPoints.toLong()
    }

    override fun solveB(): Long {
        val cardDatas = mutableListOf<CardData>()

        forEachFileLine {
            val cardData = lineParser.parseNumbersForCards(it)
            cardDatas.add(cardData)
        }

        return partBSolver.solve(cardDatas).toLong()
    }
}