package day01

fun String.allIndicesOf(string: String): List<Int> {
    var currentStr = this
    val indices = mutableListOf<Int>()
    var startingIndex = 0
    var foundIndex = 0

    while(foundIndex != -1) {
        foundIndex = currentStr.indexOf(string, startingIndex)

        if (foundIndex != -1) {
            indices.add(foundIndex)
            startingIndex = foundIndex + string.length
        }
    }

    return indices
}