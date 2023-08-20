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
}
