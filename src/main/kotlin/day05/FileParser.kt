package day05

class FileParser {
    fun parse(lines: List<String>): AlmanacData {
        val colonIndex = lines[0].indexOf(':')
        val seedsString = lines[0].substring(colonIndex + 1)
        val seeds = seedsString
            .split(' ')
            .filter { it.isNotEmpty() }
            .map { SeedRange(it.toLong(), 1) }

        val allMapLists = mutableListOf<List<AlmanacMap>>()
        var currentMapList = mutableListOf<AlmanacMap>()

        val sanitizedLines = lines.drop(3).toMutableList()
        sanitizedLines.add("fake line with the word 'map' to trigger adding the last list")

        for(line in sanitizedLines) {
            if (line.isEmpty()) {
                continue
            }

            if (line.contains("map")) {
                allMapLists.add(currentMapList)
                currentMapList = mutableListOf()
            } else {
                val map = parseLine(line)
                currentMapList.add(map)
            }
        }

        return AlmanacData(seeds, allMapLists)
    }

    private fun parseLine(line: String): AlmanacMap {
        val (destinationRangeStart, sourceRangeStart, rangeLength) = line.split(' ').map { it.toLong() }
        return AlmanacMap(sourceRangeStart, destinationRangeStart, rangeLength)
    }
}