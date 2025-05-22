package dynamicProgramming

fun main() {}

fun arrayDescriptionBackTracking(response : IntArray,
                                 arraySize : Int,
                                 i: Int,
                                 uppBound: Int,
                                 array: IntArray) {

    if(i == arraySize) {
        response[0] += 1
        return
    }

    val current = array[i]
    if(current != 0) {
        if(i == 0 || kotlin.math.abs(array[i] - array[i-1]) <= 1) {
            arrayDescriptionBackTracking(response, arraySize, i + 1, uppBound, array)
        }
        return
    }

    for(j in 1..uppBound) {
        if(i == 0 || kotlin.math.abs(array[i] - array[i-1]) <= 1) {
            array[i] = j
            arrayDescriptionBackTracking(response, arraySize, i + 1, uppBound, array)
            array[i] = 0
        }
    }
}