package dynamicProgramming

import kotlin.math.max

/*
Input:
4 10
4 8 5 3
5 12 8 1

Output:
13

Explanation: You can buy books 1 and 3. Their price is 4+5=9 and the number of pages is 5+8=13.

5 10
2 4 6 3 5
3 4 8 2 5

Output:
12
 */
fun main() {
    val (numberOfBooks, totalPrice) = readln().split(" ").map { it.toInt() }
    val priceOfBooks = readln().split(" ").map { it.toInt() }.toIntArray()
    val pagesOfBooks = readln().split(" ").map { it.toInt() }.toIntArray()
    val response = intArrayOf(0)
//    BookShopBackTrackAlgo(response = response, numberOfBooks, totalPrice, priceOfBooks, pagesOfBooks, 0,
//        BooleanArray(numberOfBooks) {false})
    val result = bookShopAlgorithm(numberOfBooks, totalPrice, priceOfBooks, pagesOfBooks)
    println(result)
}

fun BookShopBackTrackAlgo(response: IntArray,
                          numberOfBooks: Int,
                          maximumTotalPrice: Int,
                          priceOfBooks : IntArray,
                          pagesOfBooks: IntArray,
                          currentTotalPages: Int,
                          usedBook : BooleanArray) {


    response[0] = maxOf(response[0], currentTotalPages)

    for(i in 0..<numberOfBooks) {
        if(priceOfBooks[i] <= maximumTotalPrice && !usedBook[i]) {
            val currPages = currentTotalPages + pagesOfBooks[i]
            usedBook[i] = true
            BookShopBackTrackAlgo(
                response = response,
                numberOfBooks = numberOfBooks,
                maximumTotalPrice = maximumTotalPrice - priceOfBooks[i],
                priceOfBooks = priceOfBooks,
                pagesOfBooks =pagesOfBooks,
                currentTotalPages = currPages,
                usedBook = usedBook
            )
            usedBook[i] = false
        }
    }
}

fun bookShopAlgorithm(numberOfBooks: Int,
                      maximumTotalPrice: Int,
                      priceOfBooks : IntArray,
                      pagesOfBooks: IntArray) : Int {

    val dp = Array(numberOfBooks) {IntArray(maximumTotalPrice + 1)}

    for(i in 0..<numberOfBooks) {
        for(j in 0..maximumTotalPrice) {
            if(i == 0) {
                dp[i][j] = if(priceOfBooks[i] <= j) pagesOfBooks[i] else 0
            }
            else {
               if(priceOfBooks[i] <= j) {
                  val option1 = dp[i-1][j]
                   val option2 = pagesOfBooks[i] + dp[i-1][j - priceOfBooks[i]]
                   dp[i][j] = maxOf(option1, option2)
               } else {
                   dp[i][j] = dp[i -1][j]
               }
            }
        }
    }

    return dp[numberOfBooks-1][maximumTotalPrice]
}