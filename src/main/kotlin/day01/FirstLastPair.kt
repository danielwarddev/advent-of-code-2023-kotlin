package day01

class FirstLastPair {
    inner class ValueWithIndex(val value: Int, val index: Int)

    private var firstValue: ValueWithIndex? = null
    private var lastValue: ValueWithIndex? = null

    fun firstValue(): Int? = firstValue?.value
    fun lastValue(): Int? = lastValue?.value

    fun addIfFirstOrLast(value: Int, indices: List<Int>) {
        for(index in indices) {
            val valuesWithIndex = findSmallestAndLargestValue(
                ValueWithIndex(value, index),
                firstValue,
                lastValue
            )
            firstValue = valuesWithIndex.first
            if (valuesWithIndex.first != valuesWithIndex.second) {
                lastValue = valuesWithIndex.second
            }
        }
    }

    private fun findSmallestAndLargestValue(
        value1: ValueWithIndex,
        value2: ValueWithIndex?,
        value3: ValueWithIndex?
    ): Pair<ValueWithIndex, ValueWithIndex> {
        val values = listOf(value1, value2, value3)
        val sortedValues = values.mapNotNull { it }.sortedBy { it.index }
        return Pair(sortedValues.first(), sortedValues.last())
    }
}