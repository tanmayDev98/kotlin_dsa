package dynamicProgramming

fun main() {
    val response = intArrayOf(0)
//    coinComboBackTrack2Algo(response,3, 9, intArrayOf(2,3,5))
    val result = coinCombo2DpAlgo(3,9, intArrayOf(2,3,5))
    println("$result")
}

fun coinComboBackTrack2Algo(response : IntArray,
                            numberOfCoins: Int,
                            sum : Int,
                            coins : IntArray,
                            start : Int = 0) {
    //Base Case
    if(sum == 0) {
       response[0] += 1
        return
    }

    for(i in start..<numberOfCoins) {
        if(coins[i] <= sum) {
            coinComboBackTrack2Algo(response, numberOfCoins, sum - coins[i], coins, i)
        }
    }
}

fun coinCombo2DpAlgo(numberOfCoins: Int, sum: Int, coins: IntArray) : Int {
    val dp = IntArray(sum + 1)

    dp[0] = 1

    //structure for combinations
    for(coin in coins) {
        for(i in coin..sum) {
            dp[i] += dp[i - coin]
        }
    }

    return dp[sum]
}