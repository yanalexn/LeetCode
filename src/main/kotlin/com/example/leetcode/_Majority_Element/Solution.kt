package com.example.leetcode._Majority_Element

class Solution {

  /**
   * Solution from NeetCode (Boyer-Moore algorithm)
   *
   * O(n)
   *
   * O(1) instead of O(n) for an easy solution using a hash map
   */
  fun majorityElement(nums: IntArray): Int {
    var result = nums[0]
    var count = 1
    for (i in 1 until nums.size) {
      if (nums[i] == result) count++
      else count--
      if (count < 0) {
        result = nums[i]
        count = 1
      }
    }
    return result
  }

  /**
   * Slightly improved syntax
   */
  fun majorityElement2(nums: IntArray): Int {
    var count = 0
    var majorityElement = 0
    nums.forEach{
      if(count == 0)majorityElement = it
      count += if(it == majorityElement) 1 else -1
    }
    return majorityElement
  }
}
