package day02

data class CubeCount(val color: String, val count: Int)

class CubeSetParser {
    fun parseLine(line: String): List<List<CubeCount>> {
        val allSetCounts = mutableListOf<List<CubeCount>>()

        val cubeSets = line
            .split(';')
            .map { it.split(',') }

        for(setStrings in cubeSets) {
            val setCounts = mutableListOf<CubeCount>()

            for(colorCountString in setStrings) {
                val countString = colorCountString.trim()
                val dividerIndex = countString.indexOf(' ')

                val count = countString.substring(0, dividerIndex).toInt()
                val color = countString.substring(dividerIndex + 1)

                setCounts.add(CubeCount(color, count))
            }

            allSetCounts.add(setCounts)
        }

        return allSetCounts
    }
}