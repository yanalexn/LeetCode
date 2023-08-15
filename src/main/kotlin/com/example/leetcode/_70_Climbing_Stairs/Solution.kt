package com.example.leetcode._70_Climbing_Stairs

import kotlin.math.pow
import kotlin.math.round
import kotlin.math.roundToInt
import kotlin.math.sqrt

class Solution {
//  fun climbStairs(n: Int): Int =
//    when (n) {
//      1 -> 1
//      2 -> 2
//      else -> climbStairs(n - 2) + climbStairs(n - 1)
//    }

  fun climbStairs(n: Int): Int {
    val phi = (1 + sqrt(5.0)) / 2
    return (round(phi.pow(n + 1)) / sqrt(5.0)).roundToInt()
  }

  /**
   * The DP algorithm of the Fibonacci numbers as it is supposed to be
   * O(n)
   * O(1)
   */
  fun climbStairs2(n: Int): Int {
    if (n == 1) return 1
    if (n == 2) return 2
    var penultimate = 1
    var ultimate = 2
    var result = 0
    for (i in 3..n) {
      result = ultimate + penultimate
      penultimate = ultimate
      ultimate = result
    }
    return result
  }
}
