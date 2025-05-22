package dynamicProgramming

fun main() {}

fun editDistance(response: IntArray,
                 string1: String,
                 string2: String,
                 i : Int = 0,
                 j : Int = 0,
                 currentSteps: Int = 0) {

    if(i == string1.length && i == string2.length) {
        response[0] = minOf(response[0], currentSteps)
    }

    if(i == string1.length) {
        editDistance(response, string1, string2, i, j+1, currentSteps+1)
    }

    if(j == string2.length) {
        editDistance(response, string1, string2, i+1, j, currentSteps + 1)
    }

    if(string1[i] == string2[i]) {
        editDistance(response, string1, string2, i+1, j+1, currentSteps)
    } else {
        //replace
        editDistance(response, string1, string2, i+1, j+1, currentSteps+1)
        //add
        editDistance(response, string1, string2, i, j+1, currentSteps + 1)
        //delete
        editDistance(response, string1, string2, i+1, j, currentSteps + 1)
    }
}

fun editDistance(string1 : String, string2 : String) : Int {
    val dp = Array(string1.length + 1) {IntArray(string2.length + 1)}
    val m = string1.length
    val n = string2.length

    for(i in 0..string1.length) dp[i][n] = m - i
    for(j in 0..string2.length) dp[m][j] = n - j

    for(i in string1.length-1 downTo 0) {
        for(j in string2.length-1 downTo 0) {
            if (string1[i] == string2[j]) {
                dp[i][j] = dp[i + 1][j + 1]
            } else {
                val insert = 1 + dp[i][j + 1]
                val delete = 1 + dp[i + 1][j]
                val replace = 1 + dp[i + 1][j + 1]
                dp[i][j] = minOf(insert, delete, replace)
            }
        }
    }

    return dp[0][0]
}