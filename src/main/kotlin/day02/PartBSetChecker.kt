package day02

class PartBSetChecker: SetChecker {
    override fun checkSet(gameId: Int, cubeSets: List<List<CubeCount>>): Int {
        var largestRed = -1
        var largestGreen = -1
        var largestBlue = -1

        for(set in cubeSets) {
            for(cubeCount in set) {
                if (cubeCount.color == "red" && cubeCount.count > largestRed) {
                    largestRed = cubeCount.count
                } else if (cubeCount.color == "green" && cubeCount.count > largestGreen) {
                    largestGreen = cubeCount.count
                } else if (cubeCount.color == "blue" && cubeCount.count > largestBlue) {
                    largestBlue = cubeCount.count
                }
            }
        }

        return listOf(largestRed, largestGreen, largestBlue)
            .filter { it != -1 }
            .reduce { accumulator, element -> accumulator * element }

    }
}