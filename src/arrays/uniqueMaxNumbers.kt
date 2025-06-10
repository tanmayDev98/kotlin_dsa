package arrays//find out two max unique elements
//example: [1,5,2,4,5]

fun main() {
    val input = intArrayOf(4,2,1,6,5)
    getUniqueMaxElements(input)
}


fun getUniqueMaxElements(input: IntArray) {
    var firstMax = Int.MIN_VALUE
    var secondMax = Int.MIN_VALUE

    // First pass: Find the top two unique max values
    for (num in input) {
        if (num > firstMax) {
            secondMax = firstMax
            firstMax = num
        } else if (num > secondMax && num != firstMax) {
            secondMax = num
        }
    }

    val output = mutableListOf<Int>()

    // Second pass: Find their first indices
    for ((index, value) in input.withIndex()) {
        if (value == firstMax || value == secondMax) {
            output.add(index)
            if (output.size == 2) break
        }
    }

    println("Top 2 unique max elements: $firstMax and $secondMax")
    println("Their indices: $output")
}