package org.example

import day04.Day4
import day04.LineParser
import day04.PartASolver
import day04.PartBSolver

fun main() {
    val day = Day4(
        "src/main/kotlin/day04/input.txt",
        LineParser(),
        PartASolver(),
        PartBSolver()
    )
    println(day.solveB())
}