package com.example.leetcode._Combination_Sum_II

class Solution {
  fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    candidates.sort()
    backtrack(candidates, target, mutableListOf<Int>(), result)
    return result.toList()
  }

  private fun backtrack(
    candidates: IntArray,
    target: Int,
    combination: MutableList<Int>,
    result: MutableList<List<Int>>,
    start: Int = 0
  ) {
    if (target < 0) {
      return
    }
    if (target == 0) {
      result.add(combination.toList())
      return
    }
    var i = start
    while (i < candidates.size) {
      combination.add(candidates[i])
      backtrack(candidates, target - candidates[i], combination, result, i + 1)
      combination.removeLast()
      i++
      while (i < candidates.size && candidates[i] == candidates[i - 1]) {
        i++
      }
    }
  }
}
