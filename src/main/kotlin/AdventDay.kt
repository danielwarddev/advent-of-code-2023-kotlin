package org.example

import java.io.File

abstract class AdventDay(open val inputFilePath: String) {
    abstract fun solveA(): Int
    abstract fun solveB(): Int

    protected fun getAllFilesLines() = File(inputFilePath).useLines { it.toList() }

    protected fun forEachFileLine(function: (line: String) -> Unit) =
        File(inputFilePath).forEachLine { function(it) }

}