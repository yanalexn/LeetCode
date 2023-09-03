package com.example.leetcode._Merge_Triplets_to_Form_Target_Triplet

class Solution {

  /**
   * O(n)
   *
   * O(1)
   */
  fun mergeTriplets(triplets: Array<IntArray>, target: IntArray): Boolean {
    val isPossible = BooleanArray(3) { false }
    for (triplet in triplets) {
      repeat(3) {
        if (triplet[it] == target[it]
          && triplet[(it + 1) % 3] <= target[(it + 1) % 3]
          && triplet[(it + 2) % 3] <= target[(it + 2) % 3])
          isPossible[it] = true
      }
    }
    repeat(3) {
      if (!isPossible[it])
        return false
    }
    return true
  }
}
