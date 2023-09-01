package com.example.leetcode._Jump_Game_II

class Solution {

  /**
   * O(n)
   *
   * O(1)
   */
  fun jump(nums: IntArray): Int {
    if (nums.size == 1) return 0
    if (nums[0] >= nums.size - 1) return 1
    var maxDist = nums[0]
    var prevMax = 0
    var cur = 1
    var counter = 1
    while(maxDist < nums.size - 1) {
      prevMax = maxDist
      for (i in cur..maxDist) {
        maxDist = maxOf(maxDist, nums[i] + i)
        if (maxDist >= nums.size - 1)
          return ++counter
      }
      counter++
      cur = prevMax + 1
    }
    return counter
  }
}
