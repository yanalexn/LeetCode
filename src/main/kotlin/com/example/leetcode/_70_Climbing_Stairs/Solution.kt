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
}
