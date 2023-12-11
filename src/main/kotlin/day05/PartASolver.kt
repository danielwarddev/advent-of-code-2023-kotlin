package day05

class PartASolver {
    fun solve(almanacData: AlmanacData): Map<Long, Long> {
        val seedMap = almanacData.seedsRanges.map { it to it }.toMap().toMutableMap()

        for(entry in seedMap) {
            var i = 0
            var currentMappedValue = entry.value

            while (i < almanacData.mapLists.size) {
                val currentMapList = almanacData.mapLists[i]

                var mappedValueInList: Long? = null
                var j = 0
                while (mappedValueInList == null && j < currentMapList.size) {
                    mappedValueInList = currentMapList[j].getMappedValue(currentMappedValue)
                    j++
                }

                if (mappedValueInList != null) {
                    currentMappedValue = mappedValueInList
                }

                i++
            }

            seedMap[entry.key] = currentMappedValue
        }

        return mapOf()
    }

    private fun getRangeOverlap(range1Start, range1Length, range2Start, range2Length): Long {

    }
}