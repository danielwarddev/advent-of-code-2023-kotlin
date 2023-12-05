package day04

class PartBSolver {
    fun solve(cardDatas: List<CardData>): Int {
        var totalCount = 0
        var currentCardDatas = cardDatas

        repeat(cardDatas.size) {
            totalCount += calculateTotalCards(currentCardDatas)
            currentCardDatas = cardDatas.drop(it + 1)
        }

        return totalCount
    }

    private fun calculateTotalCards(cardDatas: List<CardData>): Int {
        var totalValue = 1

        repeat(cardDatas[0].matchingNumbersCount) {
            val cardDatasAfterFirst = cardDatas.drop(it + 1)
            if (cardDatasAfterFirst.isNotEmpty()) {
                totalValue += calculateTotalCards(cardDatasAfterFirst)
            }
        }

        return totalValue
    }
}