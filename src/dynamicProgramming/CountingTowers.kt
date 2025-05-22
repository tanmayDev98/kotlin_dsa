package dynamicProgramming

fun countingTowersBackTracking(response : IntArray,
                               height : Int,
                               width: Int = 2) {


    if(height == 0) {
        response[0] += 1
        return
    }
    
    countingTowersBackTracking(response, height - 1)
}