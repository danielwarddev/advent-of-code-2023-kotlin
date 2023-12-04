package shared

import kotlin.test.Test
import kotlin.test.assertContentEquals

class FileHelperTest {
    private val fileHelper = FileHelper()

    @Test
    fun `bubbles up File useLines return values`() {
        val filePath = "src/test/kotlin/shared/testInputA.txt"
        val expectedLines = listOf("line one", "line two", "line three")

        val actualLines = fileHelper.readAllLines(filePath)

        assertContentEquals(expectedLines, actualLines)
    }
}