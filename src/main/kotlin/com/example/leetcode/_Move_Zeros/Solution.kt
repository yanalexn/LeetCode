package com.example.leetcode._Move_Zeros

class Solution {
  /**
   * O(n)
   *
   * O(1)
   */
  fun moveZeroes(nums: IntArray): Unit {
    if (nums.size == 1) return
    var idxOfChecked = 0
    for (i in nums.indices) {
      if (nums[i] == 0) {
        continue
      } else if (i != idxOfChecked) {
        nums[idxOfChecked] = nums[i]
        nums[i] = 0
      }
      idxOfChecked++
    }
  }
}
