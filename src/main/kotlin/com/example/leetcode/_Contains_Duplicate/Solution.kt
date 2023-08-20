package com.example.leetcode._Contains_Duplicate

class Solution {

  /**
   * slightly improved after reading other solutions
   *
   * O(n)
   *
   * O(n)
   */
  fun containsDuplicate(nums: IntArray): Boolean {
    val memo = hashSetOf<Int>()
    nums.forEach {
      if (!memo.add(it))
        return true
    }
    return false
  }
}
