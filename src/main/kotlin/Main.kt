package org.example

import day04.Day4
import day04.LineParser
import day04.PartASolver
import day04.PartBSolver
import day05.Day5
import day05.FileParser

fun main() {
    val day = Day5(
        "src/main/kotlin/day05/input.txt",
        FileParser(),
        day05.PartASolver()
    )
    println(day.solveA())
}