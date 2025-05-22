package dynamicProgramming

import kotlin.math.abs

fun main() {}


fun longestDecreasingDiffSubSequence(response:IntArray,
                                     nums: IntArray,
                                     prevDiff: Int = -1,
                                     length: Int = 1,
                                     i : Int = 0) {

    if(i == nums.size ) {
        response[0] = maxOf(response[0], length)
        return
    }

    for(j in 0..<i) {
        val currDiff = abs(nums[i] - nums[j])
        if(prevDiff == -1 || prevDiff >= currDiff) {
            longestDecreasingDiffSubSequence(response, nums, currDiff,length+1, i + 1)
        }
        longestDecreasingDiffSubSequence(response, nums, prevDiff, length, i+1)
    }
}