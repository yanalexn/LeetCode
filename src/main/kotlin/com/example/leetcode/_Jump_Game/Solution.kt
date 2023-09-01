package com.example.leetcode._Jump_Game

class Solution {

  /**
   * My first solution ever was quite a mess, it spends almost O(n!) time
   *
   * And, as expected, it exceeded the LeetCode time limit
   */
  fun canJump0(nums: IntArray, end: Int = nums.size - 1): Boolean {
    if (nums[0] >= end) return true
    for (i in 1..end-1) {
      if (nums[i] >= end - i && canJump0(nums, i))
        return true
    }
    return false
  }

  /**
   * For some reason this topic is called "greedy algorithms"
   *
   * O(n)
   *
   * O(1)
   */
  fun canJump(nums: IntArray): Boolean {
    if (nums[0] >= nums.size - 1) return true
    var maxDist = nums[0]
    var prevMax = 0
    var cur = 1
    while(maxDist != prevMax) {
      prevMax = maxDist
      if (maxDist >= nums.size - 1)
        return true
      for (i in cur..maxDist) {
        maxDist = maxOf(maxDist, nums[i] + i)
        if (maxDist >= nums.size - 1)
          return true
      }
      cur = prevMax + 1
    }
    return false
  }
}
