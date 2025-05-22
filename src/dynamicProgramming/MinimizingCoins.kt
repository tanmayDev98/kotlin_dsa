package dynamicProgramming

import java.io.DataInput

//Solution with backtracking algorithm
fun main() {
    val coins = intArrayOf(1, 2, 5)
    val sum = 11
    val response = intArrayOf(Int.MAX_VALUE)

//    backtrackingAlgo(response, coins, sum, coins.size, 0)
//
//    if (response[0] == Int.MAX_VALUE) {
//        println("No solution")
//    } else {
//        println("Minimum coins needed: ${response[0]}")
//    }

        println(dpAlgo(11, coins, 3))
}

fun backtrackingAlgo(response : IntArray,
                     coins : IntArray,
                     sum : Int, numberOfCoins : Int,
                     currentCoins : Int) {
    if(sum == 0) {
        response[0] = minOf(response[0], currentCoins)
        return
    }

    for(i in 0..<numberOfCoins) {
        if(coins[i] <= sum) {
            backtrackingAlgo(response, coins, sum - coins[i], numberOfCoins, currentCoins + 1)
        }
    }
}

fun dpAlgo(sum: Int, coins : IntArray, numberOfCoins: Int) : Int {
    val dp = MutableList<Int>(sum + 1) {Int.MAX_VALUE}
    dp[0] = 0

    for(i in 1..sum) {
        for(coin in coins) {
            if(coin <= i) {
                dp[i] = minOf(dp[i], dp[i - coin] + 1)
            }
        }
    }

    return dp[sum]
}