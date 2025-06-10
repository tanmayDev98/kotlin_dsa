package arrays

fun main() {
    val sol = LongestConsecutiveSolution()
    println(sol.longestConsecutive(intArrayOf(100,2,3,0,1,200,400)))
}

class LongestConsecutiveSolution {
    fun longestConsecutive(nums: IntArray): Int {
        val numsSet = nums.toHashSet()
        var counter = 0
        for(i in numsSet) {
            if(!numsSet.contains(i - 1)) {
                var currentNum = i
                var currentCounter = 1

                while(numsSet.contains(currentNum + 1)) {
                    currentNum += 1
                    currentCounter += 1
                }

                counter = maxOf(counter, currentCounter)
            }
        }
        return counter
    }
}