package org.example

import java.io.File

abstract class AdventDay(open val inputFilePath: String) {
    abstract fun solveA(): Long
    abstract fun solveB(): Long

    protected fun getAllFilesLines() = File(inputFilePath).useLines { it.toList() }

    protected fun forEachFileLine(function: (line: String) -> Unit) =
        File(inputFilePath).forEachLine { function(it) }

}