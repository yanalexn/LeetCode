package com.example.leetcode._Missing_Number


class Solution {
  fun missingNumber(nums: IntArray): Int {
    var sum = 0
    for (num in nums) {
      sum += num
    }
    return nums.size * (nums.size + 1) / 2 - sum
  }
}
