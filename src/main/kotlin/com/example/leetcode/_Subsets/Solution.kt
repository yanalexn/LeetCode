package com.example.leetcode._Subsets

class Solution {
  fun subsets(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    backtracking(nums, mutableListOf<Int>(), result)
    return result
  }

  private fun backtracking(
    nums: IntArray,
    subset: MutableList<Int>,
    result: MutableList<List<Int>>,
    start: Int = 0
  ) {
    if (start >= nums.size) {
      result.add(ArrayList(subset))
      return
    }
    backtracking(nums, subset, result, start + 1)
    subset.add(nums[start])
    backtracking(nums, subset, result, start + 1)
    subset.removeLast()
  }
}
