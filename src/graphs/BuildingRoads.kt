package graphs

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val componentMap = mutableMapOf<Int, MutableList<Int>>()

    val dsu = DSU<Int>()
    for(i in 1..n) dsu.makeSet(i)

    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        dsu.union(a, b)
    }

    val representatives = mutableSetOf<Int>()
    for(i in 1..n) {
        //Replacing this to find the smallest node as logical representative
        //representatives.add(dsu.find(i))

        val root = dsu.find(i)
        componentMap.computeIfAbsent(root) { mutableListOf() }.add(i)
    }

    //val repsList = representatives.toList()
    println(componentMap)

    //To get minimum representatives
    val repsList = componentMap.values.map { it.minOrNull()!! }.sorted()
    val connectionsToAdd = repsList.size - 1

    println(connectionsToAdd)
    for (i in 1..<repsList.size) {
        println("${repsList[i - 1]} ${repsList[i]}")
    }
}