package day02

class LineParser(
    private val cubeSetParser: CubeSetParser,
    private val gameIdParser: GameIdParser,
) {
    fun parseLine(line: String, setChecker: SetChecker): Int {
        val dividerIndex = line.indexOf(':')
        val cubeSetsLine = line.substring(dividerIndex + 2)

        val gameId = gameIdParser.parseGameId(line)
        val cubeSets = cubeSetParser.parseLine(cubeSetsLine)

        return setChecker.checkSet(gameId, cubeSets)
    }
}