package day05

import kotlin.math.min

data class AlmanacData(
    val seedsRanges: List<SeedRange>,
    val mapLists: List<List<AlmanacMap>>
)

data class SeedRange(
    val seedStart: Long,
    val seedRange: Long
)

data class AlmanacMap(
    val sourceRangeStart: Long,
    val destinationRangeStart: Long,
    val rangeLength: Long
) {
    fun getMappedValue(value: Long): Long? {
        val sourceRangeEnd = sourceRangeStart + rangeLength - 1

        if (value < sourceRangeStart ||
            value > sourceRangeEnd
        ) {
            return null
        }

        val indexInRange = value - sourceRangeStart
        val desiredDestinationValue = destinationRangeStart + indexInRange

        return desiredDestinationValue
    }

    fun getMappedRange(range: SeedRange): SeedRange? {
        val seedRangeEnd = range.seedStart + range.seedRange - 1
        val sourceRangeEnd = sourceRangeStart + rangeLength - 1

        if (range.seedStart > sourceRangeEnd ||
            seedRangeEnd > sourceRangeStart
        ) {
            return null
        }

        val mappedRangeStart = min(range.seedStart, sourceRangeStart)
        val mappedRangeEnd = min(seedRangeEnd, sourceRangeEnd)
        val mappedRangeLength = mappedRangeEnd - mappedRangeStart

        return SeedRange(mappedRangeStart, mappedRangeLength)
    }
}