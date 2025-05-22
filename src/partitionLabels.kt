fun main() {
    val sol = PartitionSolution()
    println(sol.partitionLabels("ababcbacadefegdehijhklij"))
}

class PartitionSolution {
    fun partitionLabels(s: String): List<Int> {
        val map : MutableMap<Char, Int> = mutableMapOf()
        for(i in s.indices) {
            map[s[i]] = i
        }
        val result = mutableListOf<Int>()
        var start = 0
        var end = 0
        for(i in s.indices) {
            end = maxOf(end, map[s[i]]!!)
            if(i == end) {
                result.add(end - start + 1)
                start = i + 1
            }
        }

        return result
    }
}