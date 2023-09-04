package com.example.leetcode._Combination_Sum

class Solution {
  fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    backtracking(candidates, target, 0, mutableListOf<Int>(), result)
    return result
  }

  private fun backtracking(
    candidates: IntArray,
    target: Int,
    start: Int,
    combination: MutableList<Int>,
    result: MutableList<List<Int>>
  ) {
    if (target == 0) {
      result.add(ArrayList(combination))
      return
    }
    if (target < 0)
      return
    for (i in start until candidates.size) {
      combination.add(candidates[i])
      backtracking(candidates, target - candidates[i], i, combination, result)
      combination.removeLast()
    }
  }
}
