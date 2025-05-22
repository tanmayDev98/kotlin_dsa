package sorting

fun main() {
    val s = intArrayOf(8,9,10,3,4,5,6,7,8)
    val sol = selectionSort(s)
    println(sol.contentToString())
}

//time complexity - selection sort takes half the steps of bubble sort
//technically the time complexity is o(n2/2)
//But empirically since we ignore the constants in o(n2) we get two
fun selectionSort(input : IntArray): IntArray {
    for( i in input.indices) {
        var lowestNumberIndex = i;
        for(j in (i + 1)..<input.size) {
            //(N - 1) + (N - 2) + (N - 3) … + 1 comparisons.
            if(input[j] < input[lowestNumberIndex]) {
                lowestNumberIndex = j
            }
        }
        //we make only one swap for every comparison
        if(lowestNumberIndex != i) {
            input[i] = input[lowestNumberIndex].also { input[lowestNumberIndex] = input[i] }
        }
    }

    return input
}