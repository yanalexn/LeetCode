package com.example.leetcode._Power_of_Three

class Solution {

  /**
   * O(log_3 (n))
   *
   * O(1)
   */
  fun isPowerOfThree(n: Int): Boolean {
    if (n <= 2 && n != 1) return false
    if (n == 1) return true
    var temp = n
    while (temp != 1) {
      if (temp % 3 != 0) return false
      temp /= 3
    }
    return true
  }
}
