package dynamicProgramming

fun main() {
    val response = intArrayOf(0)
    houseRobber(response, intArrayOf(1,2,3,1))
    println(response[0])
}

fun houseRobber(response: IntArray,
                moneyArr: IntArray,
                i: Int = 0,
                sum : Int = 0) {

    if(i >= moneyArr.size) {
        response[0] = maxOf(response[0], sum)
        return
    }

    if(i < moneyArr.size -1) {
        val tempSum = sum + moneyArr[i]
        houseRobber(response, moneyArr, i + 2, tempSum)
    }

    houseRobber(response, moneyArr, i+1, sum)
}

fun houseRobberDpAlgorithm(inputArr: IntArray) : Int {
    val dp = IntArray(inputArr.size + 1)

    dp[inputArr.size] = 1

    for(i in inputArr.size - 1 downTo 0) {
        val opt1 = if(i + 2 <= inputArr.size - 1) {
            inputArr[i] + dp[i+2]
        } else {inputArr[i]}
        val opt2 = dp[i+1]
        dp[i] = maxOf(opt1, opt2)
    }

    return dp[0]
}