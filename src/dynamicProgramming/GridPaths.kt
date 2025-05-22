package dynamicProgramming

fun main() {
    val input = 4
    val arrayInput = Array(input) { Array(input) { '.' } }

    arrayInput[1][1] = '*'
    arrayInput[2][3] = '*'
    arrayInput[3][0] = '*'

    val response = intArrayOf(0)
    //gridPathsBacktrackingAlgo(response, input, arrayInput, 0, 0)
    val result = gridPathsDpAlgorithm(input, arrayInput)
    println("$result")
}

fun gridPathsBacktrackingAlgo(response : IntArray,
                              input : Int,
                              arr: Array<Array<Char>>,
                              row: Int,
                              column: Int) {

    if(row == input - 1 && column == input - 1) {
        response[0] += 1
        return
    }

    if(row + 1 < input && arr[row+1][column] != '*') {
        gridPathsBacktrackingAlgo(response, input, arr, row+1, column)
    }

    if(column + 1  < input && arr[row][column+1] != '*') {
        gridPathsBacktrackingAlgo(response, input, arr, row, column + 1 )
    }
}

fun gridPathsDpAlgorithm(input: Int, grid: Array<Array<Char>>) : Int{

    val dp = Array(input + 1) { IntArray(input + 1)}

    if(grid[0][0] == '*') return 0
    dp[0][0] = 1

    for(row in 0..<input) {
        for(column in 0..<input) {
            if(grid[row][column] == '*') {
                dp[row][column] = 0
                continue
            }

            if(row == 0 && column == 0) continue

            var option1 = 0
            var option2 = 0

            option1 = if(row > 0) dp[row-1][column] else 0
            option2 = if(column > 0) dp[row][column-1] else 0

            dp[row][column] = option1 + option2
        }
    }

    return dp[input - 1][input - 1]
}