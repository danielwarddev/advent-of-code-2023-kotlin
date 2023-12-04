package day02

interface SetChecker {
    fun checkSet(gameId: Int, cubeSets: List<List<CubeCount>>): Int
}

class PartASetChecker : SetChecker {
    override fun checkSet(gameId: Int, cubeSets: List<List<CubeCount>>): Int {
        for(set in cubeSets) {
            for(cubeCount in set) {
                if (cubeCount.color == "red" && cubeCount.count > 12 ||
                    cubeCount.color == "green" && cubeCount.count > 13 ||
                    cubeCount.color == "blue" && cubeCount.count > 14
                ) {
                    return 0
                }
            }
        }

        return gameId
    }
}