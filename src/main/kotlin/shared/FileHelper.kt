package shared

import java.io.File

class FileHelper() {
    fun readAllLines(filePath: String): List<String>
        = File(filePath).useLines{ it.toList() }
}