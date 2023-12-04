package day02

class GameIdParser {
    fun parseGameId(line: String): Int {
        val beforeGameId = "Game "
        val afterGameId = ": "

        val beforeGameIdIndex = line.indexOf(beforeGameId)
        val afterGameIdIndex = line.indexOf(afterGameId)

        val gameId = line.substring(
            beforeGameIdIndex + beforeGameId.length,
            afterGameIdIndex
        )

        return gameId.toInt()
    }
}