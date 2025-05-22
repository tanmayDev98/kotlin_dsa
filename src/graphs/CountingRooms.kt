package graphs

fun main() {
    val n = 5
    val m = 8

    val grid = listOf(
        "########",
        "#..#...#",
        "####.#.#",
        "#..#...#",
        "########"
    )

    val visited = MutableList(n) { MutableList(m) { false } }
    var roomCount = 0

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (grid[i][j] == '.' && !visited[i][j]) {
                dfs(i, j, grid, visited, n, m)
                roomCount++
            }
        }
    }

    println("Number of rooms: $roomCount")
}

fun dfs(
    i: Int,
    j: Int,
    grid: List<String>,
    visited: MutableList<MutableList<Boolean>>,
    rows: Int,
    cols: Int
) {
    if (i !in 0..<rows || j !in 0..<cols) return
    if (grid[i][j] == '#' || visited[i][j]) return

    visited[i][j] = true

    dfs(i + 1, j, grid, visited, rows, cols)
    dfs(i - 1, j, grid, visited, rows, cols)
    dfs(i, j + 1, grid, visited, rows, cols)
    dfs(i, j - 1, grid, visited, rows, cols)
}
