package day04

data class CardData(val cardId: Int, val matchingNumbersCount: Int)

class LineParser {
    fun parseNumbersForCards(line: String): CardData {
        val trimmedLine = line.replace("Card", "").trim()
        val numbersStartIndex = trimmedLine.indexOf(':')

        val cardNumber = trimmedLine.substring(0, numbersStartIndex).toInt()
        val numbersString = trimmedLine.substring(numbersStartIndex + 2)

        val (winningNumbersString, ownedNumbersString) = numbersString.split('|')
        val winningNumbers = parseSpaceDelimitedNumbers(winningNumbersString)
        val ownedNumbers = parseSpaceDelimitedNumbers(ownedNumbersString)

        return CardData(cardNumber, winningNumbers.intersect(ownedNumbers).size)
    }

    private fun parseSpaceDelimitedNumbers(line: String): List<Int> {
        return line
            .split(' ')
            .map { it.trim() }
            .filter { it.isNotEmpty() }
            .map { it.toInt() }
    }
}
