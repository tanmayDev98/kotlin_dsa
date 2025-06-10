package arrays

//Input = [1,1,1,0,0,1,0]
//output = [0,0,0,0,1,1,1]

fun main() {
    val input = intArrayOf(0,1,0,1,0,1,0)
    val output = sortZeroes(input)
    println(output.contentToString())
}

fun sortZeroes(input : IntArray) : IntArray {
    var zeroRefPtr : Int = 0;
    var temp = -1;
    for(i in input.indices) {
        if(input[i] < input[zeroRefPtr] ) {
            temp = input[i]
            input[i] = input[zeroRefPtr]
            input[zeroRefPtr] = temp
        }  else if(input[i] > input[zeroRefPtr]) {
            zeroRefPtr++
        }
    }
    return input
}