package com.example.leetcode._House_Robber

class Solution {

  /**
   * O(n)
   *
   * O(1)
   */
  fun rob(nums: IntArray): Int {
    var prev2 = 0
    var max = 0
    for (n in nums) {
      val temp1 = max
      max = maxOf(n + prev2, max)
      prev2 = temp1
    }
    return max
  }
}
