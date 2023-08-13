package com.example.leetcode._Reverse_String

class Solution {

  /**
   * O(n) - time complexity
   * O(1) - space complexity
   */
  fun reverseString(s: CharArray): Unit {
    for (i in 0..(s.size - 1) / 2) {
      val temp = s[i]
      s[i] = s[s.size - 1 - i]
      s[s.size - 1 - i] = temp
    }
  }
}
