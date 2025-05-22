package dynamicProgramming

fun main() {
    val input = readln().toInt()
    val dp = MutableList(input + 1) {0}
    dp[0] = 1
    for(i in 1..input) {
        for(x in 1..6) {
            if(x > i)
                break
            dp[i] += dp[i - x]
        }
    }
    println(dp[input])
}