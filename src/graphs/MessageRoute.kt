package graphs

import java.util.LinkedList
import java.util.Queue

fun main() {}

fun messageRouteBfs(n: Int,
                    m: Int,
                    adjList: List<List<Int>>,
                    visited: MutableList<Boolean>) {
    val queue : Queue<Int> = LinkedList()
    queue.add(1)

    if (1 == n) {
        println(1)
        println(1)
        return
    }

    if(!visited[n]) {
        println("IMPOSSIBLE")
        return
    }

    while(queue.isNotEmpty()) {
        val v = queue.poll()

        if(!visited[v]) {
            visited[v] = true
            for(i in adjList[v]) {
                if(!visited[i]) {
                    visited[i] = true
                    queue.add(i)
                }
            }
        }
    }
}