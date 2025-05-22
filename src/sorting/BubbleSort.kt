package sorting

fun main() {
    val input = intArrayOf(1,2,3,4,5,6,7,8,9,10)
    val bSort  = bubbleSort(input)
    println(bSort.contentToString())
}

//Time efficiency is O(n2) - quadratic time
fun bubbleSort(inputArray : IntArray) : IntArray {
    var unsorted_until_index = inputArray.size - 1
    var sorted = false

    while(!sorted) {
        sorted = true
        for(i in 0..<unsorted_until_index) {
            //(N-1) + (N-2) + (N-3).... + 1 comparisons
            if(inputArray[i] > inputArray[i+1]) {
                sorted = false
                inputArray[i] = inputArray[i+1].also { inputArray[i+1] = inputArray[i] }
            }
        }
        unsorted_until_index -= 1
    }

    return inputArray
}