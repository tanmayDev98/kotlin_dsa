package graphs

fun main() {
    val graph = UnDirectedGraph(6)

    graph.addEdge(1,2)
    graph.addEdge(1,5)
    graph.addEdge(2,3)
    graph.addEdge(5,4)
    graph.addEdge(3,4)
    graph.addEdge(4,6)

    val adjacentTo4 = graph.getNodesAdjacentToNode(4)
    println("Nodes adjacent to node 4: $adjacentTo4")
}

class UnDirectedGraph(nodes: Int) {
    private val adjList : MutableList<MutableList<Int>> = MutableList(nodes + 1) { mutableListOf() }
    private val numberOfNodes = nodes

    fun addEdge(u : Int, v: Int) {
        adjList[u].addLast(v)
        //for directed graph we don't add edge in this
        adjList[v].addLast(u)
    }

    fun getNodes() : Int {
        return numberOfNodes
    }

    fun getNodesAdjacentToNode(x : Int): MutableList<Int> {
        return adjList[x]
    }
}