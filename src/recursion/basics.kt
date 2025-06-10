package recursion

fun main() {
    fibonacciSeries(5)
}

fun printName(name: String, times: Int, count: Int = 1) {
    if(count > times ) {
       return
    }
    println(name)
    printName(name, times, count+1)
}

fun printNumbers(start: Int, n: Int) {
    if(start > n) {
        return
    }

    println(start)
    printNumbers(start+1, 5)
}

fun printReverseNumbers(start: Int, end: Int) {
    if(end < start) {
        return
    }

    println(end)
    printReverseNumbers(1,end -1)
}

fun sumOfNaturalNumbers(start: Int = 1, end : Int, sum: Int = 0) : Int {
    if(start > end) {
        println(sum)
        return sum
    }
    return sumOfNaturalNumbers(start+1, end, sum+start)
}

fun factorialOfNNumbers(number: Int, product : Int = 1) : Int {
    if(number == 1) {
        println(product)
        return product
    }

    return factorialOfNNumbers(number-1, product * number)
}

fun reverseArray(array: IntArray, start: Int = 0, end: Int = array.size-1) : IntArray {
    if(start > end) {
        println(array.contentToString())
        return array
    }

    array[start] = array[end].also { array[end] = array[start] }
    return reverseArray(array, start+1, end-1)
}

fun palindromeString(inputString: String, start: Int = 0, end: Int = inputString.length-1)  {
    val output: CharArray = inputString.toCharArray()

    if(start > end) {
        if (inputString == output.concatToString()) {
            println("$inputString is palindrome")
        } else {
            println("$inputString is not palindrome")
        }
        return
    }

    output.apply {
        this[start] = this[end].also { this[end] = this[start] }
    }

    palindromeString(output.concatToString(), start+1,  end-1 )
}

fun palindromeString2(inputString: String, start: Int = 0, end: Int = inputString.length -1) {

    if(start > end) {
        println("$inputString is palindrome")
        return
    }

    if(inputString[start] != inputString[end]) {
        println("$inputString is not a palindrome")
        return
    }

    palindromeString2(inputString, start+1, end-1)
}

fun fibonacciSeries(number: Int, previous: Int=0, current : Int = 1) {
    if(previous > number) {
        return
    }

    println(previous)
    fibonacciSeries(number, current,previous+(previous+current))
}