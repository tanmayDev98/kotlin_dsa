package dynamicProgramming

fun main() {
    val response = doubleArrayOf(0.0)
    soupServings(response, 50,50,50)
    println("soupServings = ${response[0]}")
}

fun soupServings(response : DoubleArray,
                 n: Int,
                 soupA : Int,
                 soupB: Int,
                 prob : Double = 1.0) {

    if(soupA <= 0 && soupB <= 0) {
         response[0] += prob * 0.5
        return
    }

    if(soupA <= 0 ) {
        response[0] += prob
        return
    }

    if(soupB <= 0) {
        return
    }

    soupServings(response, n, soupA -100, soupB, prob * 0.25)
    soupServings(response, n, soupA -75, soupB -25, prob * 0.25)
    soupServings(response, n, soupA -50, soupB -50, prob * 0.25)
    soupServings(response, n, soupA -25, soupB -75, prob * 0.25)
}