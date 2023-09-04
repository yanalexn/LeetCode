package com.example.leetcode._Subsets_II

class Solution {
  fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    nums.sort()
    val result = mutableListOf<List<Int>>()
    backtrack(nums, mutableListOf<Int>(), result)
    return result
  }

  private fun backtrack(
    nums: IntArray,
    subset: MutableList<Int>,
    result: MutableList<List<Int>>,
    idx: Int = 0,
    isSkip: Boolean = false
  ) {
    if (idx == nums.size) {
      result.add(subset.toList())
      return
    }
    if (!(idx >= 1 && nums[idx] == nums[idx - 1] && isSkip)) {
      subset.add(nums[idx])
      backtrack(nums, subset, result, idx + 1)
      subset.removeLast()
    }
    backtrack(nums, subset, result, idx + 1, true)
  }
}
