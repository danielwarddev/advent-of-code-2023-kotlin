package org.example

import day02.*
import day03.Day3
import day03.FileParser
import day03.PartASolver
import day03.PartBSolver

fun main() {
    val day = Day3(
        "src/main/kotlin/day03/input.txt",
        FileParser(),
        PartASolver(),
        PartBSolver()
    )
    println(day.solveB())
}