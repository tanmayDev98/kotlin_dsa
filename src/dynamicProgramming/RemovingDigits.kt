package dynamicProgramming

import kotlin.math.max

fun main() {
    val response = intArrayOf(Int.MAX_VALUE)
    //removingDigitsBackTrackingAlgorithm(response, 27, 0)
    val result = removingDigitsDpAlgo(inputNumber = 27)
    println(result)
}

fun removingDigitsBackTrackingAlgorithm(response: IntArray,
                                        inputNumber : Int,
                                        steps : Int) {
    if(inputNumber == 0) {
        response[0] = steps
        return
    }

    val getDigitToSubtract = getMaxDigit(inputNumber)
    removingDigitsBackTrackingAlgorithm(response, inputNumber - getDigitToSubtract, steps + 1)
}

fun removingDigitsDpAlgo(inputNumber: Int) : Int {
    val dp = IntArray(inputNumber + 1) {0}

    dp[0] = 0

    for(i in 1..inputNumber) {
        val getDigitToSubtract = getMaxDigit(i)
        dp[i] += dp[i - getDigitToSubtract] + 1
    }

    return dp[inputNumber]
}

fun getMaxDigit(inputNumber: Int) : Int {
    var maxDigit = 0
    var n = inputNumber
    while(n != 0) {
        val digit = n % 10
        if( digit >= maxDigit) {
            maxDigit = digit
        }
        n /= 10
    }
    return maxDigit
}



