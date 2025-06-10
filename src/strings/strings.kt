package basics

fun main() {
    val p  = "Tanmay"
    val c = "nm"
    println(match(p, c))
}

//string matching - brute force algorithm -searches for first occurrence in a string
//Time complexity - o(n*m)
fun match(parent: String, child: String) : Int{
    for(i in 0..<parent.length - child.length) {
        var j = 0;
        while(j < child.length && child[j] == parent[i + j]) {
            j += 1;
        }
        if(j  == child.length)
            return i
    }
    return -1
}

//string matching - Robin karp algorithm
fun rkMatching() {
    //Generate a suitable hash function
    //compare the rolling hash value
}


