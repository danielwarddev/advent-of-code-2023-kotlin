package day02

import io.mockk.every
import io.mockk.mockk
import kotlin.test.Test
import kotlin.test.assertEquals

class LineParserTest {
    private val cubeSetParser = mockk<CubeSetParser>()
    private val gameIdParser = mockk<GameIdParser>()
    private val parser = LineParser(cubeSetParser, gameIdParser)

    @Test
    fun `splits line by the first colon character and returns what the setChecker returns`() {
        val expectedResult = 10
        val gameId = 1
        val cubeSets = listOf(listOf<CubeCount>())

        every { gameIdParser.parseGameId("something: words") } returns gameId
        every { cubeSetParser.parseLine("words") } returns cubeSets

        val setChecker = mockk<SetChecker>()
        every { setChecker.checkSet(gameId, cubeSets) } returns expectedResult

        val actualResult = parser.parseLine("something: words", setChecker)

        assertEquals(expectedResult, actualResult)
    }
}