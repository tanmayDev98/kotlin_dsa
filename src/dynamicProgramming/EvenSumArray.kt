package dynamicProgramming

//Question:
/*
Find the number of lists that satisfy the following conditions: -
1.List contains exactly 'N' elements
2.All elements in list are between low to high
3.sum of all elements is even

Return answer 10^9+7

Constraints
1 <= n <= 10^6
1 <= low <= high <= 10^6

Sample:-
(n=3,low=1, high=2) -> 4
(n=3,low=1, high=2) -> 50
*/

data class InputObj(val n: Int, val low: Int, val high: Int)

fun main() {
    val inputList = listOf(
        InputObj(n = 3, low = 1, high = 2),
        InputObj(n = 2, low = 1, high = 10)
    )

    for (input in inputList) {
        val result = //dynamicProgramming.countEvenSumLists(input.n, input.low, input.high)
            generateListDp(input.n, input.low, input.high)
        println(result)
    }
}

fun countEvenSumLists(n: Int, low: Int, high: Int): Int {
    val mod = 1_000_000_007
    val response = intArrayOf(0)
    generateLists(response, n, low, high, 0, 0)
    return response[0] % mod
}

fun generateLists(
    response: IntArray,
    n: Int,
    low: Int,
    high: Int,
    index: Int,
    sum: Int
) {
    if (index == n) {
        if (sum % 2 == 0) {
            response[0] += 1
        }
        return
    }

    for (j in low..high) {
        generateLists(response, n, low, high, index + 1, sum + j)
    }
}

fun generateListDp(n: Int,
                   low: Int,
                   high: Int) : Int {

    val maxSum = n * high
    val dp = Array(n + 1) {IntArray(maxSum+1)}

    for(i in 0..maxSum) {
        dp[n][i] = if(i % 2 == 0) 1 else 0
    }

    for(index in n-1 downTo 0) {
        for (sum in 0..maxSum) {
            for(j in low..high) {
                if(sum + j <= maxSum) {
                    dp[index][sum] =(dp[index][sum] + dp[index + 1][sum + j]) % (1000000007)
                }
            }
        }
    }

    return dp[0][0]
}