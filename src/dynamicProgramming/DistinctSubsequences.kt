package dynamicProgramming

import javax.xml.transform.Source

fun main() {
    val response = intArrayOf(0)
    distanceSubsequences(response, "rabbbit", "rabbit")
    println(response[0])
}

fun distanceSubsequences(response : IntArray,
                         source : String,
                         target : String,
                         i: Int = 0,
                         j: Int = 0,) {

    if(j == target.length ) {
        response[0] += 1
        return
    }

    if(i == source.length) {
        return
    }

    if(source[i] == target[j]) {
        distanceSubsequences(response, source, target, i + 1, j+1)
    }

    distanceSubsequences(response, source, target, i+1, j)
}

fun distanceSubsequencesDp(source: String, target: String) : Int {
    val dp = Array(target.length + 1) {IntArray(source.length + 1)}

    for(j in target.length - 1 downTo 0) {
        for (i in 0..source.length) {
            dp[target.length][i] = 1
        }
        for(i in source.length - 1 downTo 0) {
            val opt1 = if (source[i] == target[j]) dp[j + 1][i + 1] else 0
            val opt2 = dp[i + 1][j]
            dp[i][j] = opt1 + opt2
        }
    }

    return dp[0][0]
}

