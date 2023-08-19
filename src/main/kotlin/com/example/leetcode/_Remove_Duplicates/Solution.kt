package com.example.leetcode._Remove_Duplicates

class Solution {
  /**
   * 1, 1, 2, 2
   *
   * O(n)
   *
   * O(1)
   */
  fun removeDuplicates(nums: IntArray): Int {
    var idx = 1
    for (i in 1 until nums.size) {
      if (nums[i] != nums[idx - 1]) {
        nums[idx] = nums[i]
        idx++
      }
    }
    return idx
  }
}
