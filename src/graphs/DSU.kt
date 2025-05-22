package graphs

fun main() {
    val dsu = DSU<Int>()

    for (i in 1..5) dsu.makeSet(i)

    dsu.union(1, 2)
    dsu.union(3, 4)
    dsu.union(2, 3)

    println("Set size of 1: ${dsu.getSetSize(1)}")
    println("Set rank of 1: ${dsu.getSetRank(1)}")
}

class DSU<T> {
    private val parent = mutableMapOf<T, T>()
    private val representativeToSetSpecs = mutableMapOf<T, Pair<Int, Int>>()

    fun makeSet(e : T) {
        parent[e] = e;
        representativeToSetSpecs[e] = Pair(1,0)
    }

    //Union By rank
    fun union(e1 : T, e2 : T) {
        val repE1 = find(e1)
        val repE2 = find(e2)

        if(repE1 == repE2) {
            return;
        }

        val (size1, rankS1) =  representativeToSetSpecs[repE1] ?: Pair(1,0)
        val (size2, rankS2) = representativeToSetSpecs[repE2] ?: Pair(1,0)

        if (rankS1 > rankS2) {
            parent[repE2] = repE1
            representativeToSetSpecs[repE1] = Pair(size1 + size2, rankS1)
            representativeToSetSpecs.remove(repE2)
        }
        else if (rankS2 > rankS1) {
            parent[repE1] = repE2
            representativeToSetSpecs[repE2] = Pair(size1 + size2, rankS2)
            representativeToSetSpecs.remove(repE1)
        }
        else {
            parent[repE1] = repE2
            representativeToSetSpecs[repE2] = Pair(size1 + size2, rankS2 + 1)
            representativeToSetSpecs.remove(repE1)
        }
    }

    //Path Compression
    fun find(e : T) : T {
        if (parent[e] != e) {
            parent[e] = find(parent[e]!!)
        }
        return parent[e]!!
    }

    fun getSetSize(e: T): Int {
        val root = find(e)
        return representativeToSetSpecs[root]?.first ?: 1
    }

    fun getSetRank(e: T): Int {
        val root = find(e)
        return representativeToSetSpecs[root]?.second ?: 0
    }
}