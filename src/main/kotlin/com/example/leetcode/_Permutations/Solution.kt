package com.example.leetcode._Permutations

class Solution {

  /**
   * O(n^n)
   *
   * O(n) of auxiliary space, that is not used as a result
   */
  fun permute(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    backtrack(nums, BooleanArray(nums.size) { true }, mutableListOf<Int>(), result)
    return result
  }

  private fun backtrack(
    nums: IntArray,
    unusedIdx: BooleanArray,
    permutation: MutableList<Int>,
    result: MutableList<List<Int>>,
    counter: Int = 0
  ) {
    if (counter == nums.size) {
      result.add(ArrayList(permutation))
      return
    }
    nums.forEachIndexed { i, value ->
      if (unusedIdx[i]) {
        permutation.add(value)
        unusedIdx[i] = false
        backtrack(nums, unusedIdx, permutation, result, counter + 1)
        permutation.removeLast()
        unusedIdx[i] = true
      }
    }
  }
}
