package dynamicProgramming

fun main() {
    val coins = intArrayOf(2, 3, 5)
    val sum = 9
    val response = intArrayOf(0)
    val numberOfCoins = 3

//    coinComboBackTrackingAlgo(response, numberOfCoins, coins, sum)
    val result = coinComboDpAlgo(numberOfCoins, sum, coins)
    println("Total Combinations: $result")
}

fun coinComboBackTrackingAlgo(response : IntArray,
                     numberOfCoins : Int,
                     coins: IntArray,
                     sum: Int) {
    if(sum == 0) {
        response[0] += 1
        return
    }

    for(i in 0..<numberOfCoins) {
        if(coins[i] <= sum) {
            coinComboBackTrackingAlgo(response, numberOfCoins, coins, sum - coins[i])
        }
    }
}

fun coinComboDpAlgo(input : Int, sum : Int, coins: IntArray) : Int {
    val dp = IntArray(sum + 1)

    dp[0] = 1

    //structure for permutations
    for(i in 1..sum) {
        for(x in coins) {
            if(x <= i) {
                dp[i] += dp[i - x]
            }
        }
    }

    return dp[sum]
}