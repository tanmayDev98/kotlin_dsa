package graphs

import java.util.LinkedList
import java.util.Queue

fun main() {
    val grid = listOf(
        "########",
        "#.A#...#",
        "#.##.#B#",
        "#......#",
        "########"
    )
    val n = 5
    val m = 8

    val visited = MutableList(n) { MutableList(m) { false } }
    //use this path for dfs , but in bfs we construct the path
//    val pathSoFar : MutableList<Char> = mutableListOf()

    for(i in 0..<n) {
        for(j in 0..<m) {
            if(!visited[i][j] && grid[i][j] == 'A' ) {
                labyrinthBfs(i, j, grid, visited, n, m)
            }
        }
    }

}

fun labyrinthDfs(
        i : Int,
        j : Int,
        grid: List<String>,
        visited: MutableList<MutableList<Boolean>>,
        rows: Int,
        cols: Int,
        path : MutableList<Char>) {

    if (i !in 0..<rows || j !in 0..<cols) return
    if(grid[i][j] == '#' || visited[i][j]) return

    if(grid[i][j] == 'B') {
        println("YES")
        println(path.size)
        println(path.joinToString(""))
        return
    }

    visited[i][j] = true

    // Down
    path.add('D')
    labyrinthDfs(i + 1, j, grid, visited, rows, cols, path)
    path.removeLast()

    // Up
    path.add('U')
    labyrinthDfs(i - 1, j, grid, visited, rows, cols, path)
    path.removeLast()

    //Right
    path.add('R')
    labyrinthDfs(i, j + 1, grid, visited, rows, cols, path)
    path.removeLast()

    //Left
    path.add('L')
    labyrinthDfs(i, j - 1, grid, visited, rows, cols, path)
    path.removeLast()
}


fun labyrinthBfs(
    startX: Int,
    startY: Int,
    grid: List<String>,
    visited: MutableList<MutableList<Boolean>>,
    rows: Int,
    cols: Int
) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(startX to startY)
    visited[startX][startY] = true

    val parent = MutableList(rows) { MutableList<Pair<Int, Int>?>(cols) { null } }
    val move = MutableList(rows) { MutableList<Char?>(cols) { null } }

    val dx = listOf(1, -1, 0, 0)
    val dy = listOf(0, 0, 1, -1)
    val dirChar = listOf('D', 'U', 'R', 'L')

    var endX = -1
    var endY = -1

    while (queue.isNotEmpty()) {
        val (x, y) = queue.remove()

        if (grid[x][y] == 'B') {
            endX = x
            endY = y
            break
        }

        for (d in 0..<4) {
            val i = x + dx[d]
            val j = y + dy[d]

            if (i in 0..<rows && j in 0..<cols &&
                grid[i][j] != '#' && !visited[i][j]
            ) {
                visited[i][j] = true
                queue.add(i to j)
                parent[i][j] = x to y
                move[i][j] = dirChar[d]
            }
        }
    }

    if (grid[endX][endY] == 'B') {
        val path = mutableListOf<Char>()
        var i = endX
        var j = endY

        while (grid[i][j] != 'A') {
            path.add(move[i][j]!!)
            val (pi, pj) = parent[i][j]!!
            i = pi
            j = pj
        }

        path.reverse()
        println("YES")
        println(path.size)
        println(path.joinToString(""))
    } else {
        println("NO")
    }
}
