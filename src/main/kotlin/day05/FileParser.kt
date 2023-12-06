package day05

data class AlmanacMap(
    val sourceRangeStart: Long,
    val destinationRangeStart: Long,
    val rangeLength: Long
) {
    fun getRangeMap(): Map<Long, Long> {
        val map = mutableMapOf<Long, Long>()

        val ranges = Pair(
            (sourceRangeStart..sourceRangeStart + rangeLength).toList(),
            (destinationRangeStart..destinationRangeStart + rangeLength).toList()
        )
        repeat(ranges.first.size) {
            map[ranges.first[it]] = ranges.second[it]
        }

        return map
    }
}

data class AlmanacData(
    val seeds: List<Long>,
    val seedToSoilMaps: List<AlmanacMap>,
    val soilToFertilizerMaps: List<AlmanacMap>,
    val fertilizerToWaterMaps: List<AlmanacMap>,
    val waterToLightMaps: List<AlmanacMap>,
    val lightToTemperatureMaps: List<AlmanacMap>,
    val temperatureToHumidityMaps: List<AlmanacMap>,
    val humidityToLocationMaps: List<AlmanacMap>
) {
    fun getRangeMap(maps: List<AlmanacMap>): Map<Long, Long> {
        val rangeMap = mutableMapOf<Long, Long>()

        for(map in maps) {
            rangeMap += map.getRangeMap()
        }

        return rangeMap
    }
}

class FileParser {
    fun parse(lines: List<String>): AlmanacData {
        val colonIndex = lines[0].indexOf(':')
        val seedsString = lines[0].substring(colonIndex + 1)
        val seeds = seedsString.split(' ').filter { it.isNotEmpty() }.map { it.toLong() }

        val seedToSoilMaps = mutableListOf<AlmanacMap>()
        val soilToFertilizerMaps = mutableListOf<AlmanacMap>()
        val fertilizerToWaterMaps = mutableListOf<AlmanacMap>()
        val waterToLightMaps = mutableListOf<AlmanacMap>()
        val lightToTemperatureMaps = mutableListOf<AlmanacMap>()
        val temperatureToHumidityMaps = mutableListOf<AlmanacMap>()
        val humidityToLocationMaps = mutableListOf<AlmanacMap>()

        val almanac = AlmanacData(
            seeds,
            seedToSoilMaps,
            soilToFertilizerMaps,
            fertilizerToWaterMaps,
            waterToLightMaps,
            lightToTemperatureMaps,
            temperatureToHumidityMaps,
            humidityToLocationMaps
        )

        var currentList = mutableListOf<AlmanacMap>()

        for(line in lines.drop(1)) {
            if (line.isEmpty()) {
                continue
            }

            when (line) {
                "seed-to-soil map:" -> currentList = seedToSoilMaps
                "soil-to-fertilizer map:" -> currentList = soilToFertilizerMaps
                "fertilizer-to-water map:" -> currentList = fertilizerToWaterMaps
                "water-to-light map:" -> currentList = waterToLightMaps
                "light-to-temperature map:" -> currentList = lightToTemperatureMaps
                "temperature-to-humidity map:" -> currentList = temperatureToHumidityMaps
                "humidity-to-location map:" -> currentList = humidityToLocationMaps
                else -> parseLine(line, currentList)
            }
        }

        return almanac
    }

    private fun parseLine(line: String, maps: MutableList<AlmanacMap>) {
        val (destinationRangeStart, sourceRangeStart, rangeLength) = line.split(' ').map { it.toLong() }
        maps.add(AlmanacMap(sourceRangeStart, destinationRangeStart, rangeLength))
    }
}