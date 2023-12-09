package day05

import java.util.LinkedList

class Node<E>(val value: E) {
    var next: Node<E>? = null
}

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

    fun getMappedValue(value: Long): Long {
        val sourceRangeEnd = sourceRangeStart + rangeLength - 1

        if (value < sourceRangeStart ||
            value > sourceRangeEnd
        ) {
            return value
        }

        val indexInRange = sourceRangeStart + value - 1
        val desiredDestinationValue = destinationRangeStart + indexInRange - 1
        val destinationRangeEnd = destinationRangeStart + rangeLength - 1

        if (desiredDestinationValue < destinationRangeStart ||
            desiredDestinationValue > destinationRangeEnd
        ) {
            return value
        }

        return desiredDestinationValue
    }
}

data class AlmanacData(
    val seeds: List<Long>,
    val frontMap: Node<List<AlmanacMap>>
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

        var currentMapList = mutableListOf<AlmanacMap>()
        var currentNode: Node<List<AlmanacMap>> = Node(listOf())

        for(line in lines.drop(1)) {
            if (line.isEmpty()) {
                continue
            }

            if (line.contains("map")) {
                var nextNode = Node(currentMapList.toList())
                val nextMapList = mutableListOf<AlmanacMap>()
                currentNode.next = nextNode
            } else {
                val map = parseLine(line)
                currentMapList.add(map)
            }
        }

        return almanacData
    }

//    private fun parseLine(line: String, maps: MutableList<AlmanacMap>) {
//        val (destinationRangeStart, sourceRangeStart, rangeLength) = line.split(' ').map { it.toLong() }
//        maps.add(AlmanacMap(sourceRangeStart, destinationRangeStart, rangeLength, null))
//    }

    private fun parseLine(line: String): AlmanacMap {
        val (destinationRangeStart, sourceRangeStart, rangeLength) = line.split(' ').map { it.toLong() }
        return AlmanacMap(sourceRangeStart, destinationRangeStart, rangeLength, null)
    }
}