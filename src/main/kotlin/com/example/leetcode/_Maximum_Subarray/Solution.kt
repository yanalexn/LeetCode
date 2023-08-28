package com.example.leetcode._Maximum_Subarray


class Solution {

  /**
   * Solution from NeetCode
   *
   * O(n)
   *
   * O(1)
   */
  fun maxSubArray(nums: IntArray): Int {
    var sum = nums[0]
    var currsum = 0
    for (num in nums) {
      currsum = maxOf(currsum + num, num)
      sum = maxOf(currsum, sum)
    }
    return sum
  }

  /**
   * My solution after 2 MIT lessons
   *
   * O(n)
   *
   * O(n)
   */
  fun maxSubArray2(nums: IntArray): Int {
    val subprobs = IntArray(nums.size)
    subprobs[nums.size - 1] = nums[nums.size - 1]
    for (i in nums.size - 2 downTo 0) {
      subprobs[i] = maxOf(nums[i], nums[i] + subprobs[i + 1])
    }
    var result = subprobs[0]
    for (i in 1 until nums.size) {
      if (subprobs[i] > result)
        result = subprobs[i]
    }
    return result
  }
}
