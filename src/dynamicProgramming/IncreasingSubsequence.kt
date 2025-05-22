package dynamicProgramming

fun main() {
    val arr = intArrayOf(7, 3, 5, 3, 6, 2, 9, 8)
//    val response = intArrayOf(0)
//    increasingSubSequence(response, arr.size, arr)
    println("Length of longest increasing subsequence: ${increasingSequenceDpAlgo(8,arr)}")
}

fun increasingSubSequence(
    response: IntArray,
    n: Int,
    arr: IntArray,
    i: Int =0,
    len: Int = 0,
    prevIdx: Int = -1)  {

    if(i == n) {
       response[0] = maxOf(response[0], len)
        return
    }

    if (prevIdx == -1 || arr[prevIdx] < arr[i]) {
        increasingSubSequence(response, n, arr,i+1,len+1, i)
    }

    increasingSubSequence(response, n, arr,i+1,len, prevIdx)
}

fun increasingSequenceDpAlgo( n: Int,
                              arr: IntArray) : Int {

    val dp = Array(n + 1) {IntArray(n + 1)}

    for(index in n-1 downTo 0) {
        for(prevIdx in n-1 downTo -1) {
            val opt1 = if (prevIdx == -1 || arr[prevIdx] < arr[index]) {
               1 + dp[index + 1][index + 1]
            } else { 0 }
            val opt2 = dp[index+1][prevIdx + 1]
            dp[index][prevIdx + 1] = maxOf(opt1, opt2)
        }
    }

    return dp[0][0]
}

