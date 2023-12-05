package day04

import org.example.AdventDay

class Day4(
    override val inputFilePath: String,
    private val lineParser: LineParser,
    private val partASolver: PartASolver,
    private val partBSolver: PartBSolver
): AdventDay(inputFilePath) {
    override fun solveA(): Int {
        var totalPoints = 0

        forEachFileLine {
            val cardData = lineParser.parseNumbersForCards(it)
            totalPoints += partASolver.solve(cardData.matchingNumbersCount)
        }

        return totalPoints
    }

    override fun solveB(): Int {
        val cardDatas = mutableListOf<CardData>()

        forEachFileLine {
            val cardData = lineParser.parseNumbersForCards(it)
            cardDatas.add(cardData)
        }

        return partBSolver.solve(cardDatas)
    }
}