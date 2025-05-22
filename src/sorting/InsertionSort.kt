package sorting

fun main() {}

//Insertion Sort will be a better choice If you have reason to assume that you’ll be dealing with
//data that is mostly sorted
// If you have reason to assume that you’ll be dealing with data that is mostly sorted in
//reverse order, Selection Sort will be faster.

fun insertionSort(inputArray : IntArray) : IntArray {
    for(i in inputArray.indices) {
        var position = i
        val tempValue = inputArray[i]
        //1 + 2 + 3 + … + N - 1 comparisons.
        //N2/2 comparisons + N2/2 shifts
        //N - 1 removals
        //N - 1 insertions
        //totoal = n2 +2N - 2 steps
        //worst case scenario is n2
        //Insertion sort takes n2/2 for average scenario
        while(position > 0 && inputArray[position - 1] > tempValue) {
            inputArray[position] = inputArray[position - 1]
            position -= 1
        }

        inputArray[position] = tempValue
    }

    return inputArray
}