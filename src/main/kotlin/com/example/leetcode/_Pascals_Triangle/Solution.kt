package com.example.leetcode._Pascals_Triangle

class Solution {

  /**
   * O(n^2)
   *
   * O(n^2)
   */
  fun generate(numRows: Int): List<List<Int>> {
    val result = mutableListOf<MutableList<Int>>()
    for (i in 0..numRows - 1) {
      result.add(mutableListOf<Int>())
      for (j in 0..i) {
        if (j == 0 || j == i)
          result[i].add(1)
        else
          result[i].add(result[i - 1][j - 1] + result[i - 1][j])
      }
    }
    return result
  }
}
