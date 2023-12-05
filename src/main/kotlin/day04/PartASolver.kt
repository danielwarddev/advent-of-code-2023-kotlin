package day04

class PartASolver {
    fun solve(matchingNumberCount: Int): Int {
        var totalPoints = if (matchingNumberCount > 0) 1 else 0
        repeat(matchingNumberCount - 1) {
            totalPoints *= 2
        }

        return totalPoints
    }
}