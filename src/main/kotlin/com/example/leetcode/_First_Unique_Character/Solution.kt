package com.example.leetcode._First_Unique_Character

class Solution {

  /**
   * super-duper slow , but accepted at the first try!
   */
  fun firstUniqChar1(s: String): Int {
    if (s.length == 1) return 0
    for (i in 0 until s.length) {
      val char = s[i]
      if (!s.substring(0, i).contains(char) && !s.substring(i + 1, s.length).contains(char)) {
        return i
      }
    }
    return -1
  }

  /**
   * much much better result
   * O(n)
   * O(1)
   *
   * learned a trick that you can interpret a character as an integer and use it as an index of an array, wow
   */
  fun firstUniqChar2(s: String): Int {
    if (s.isEmpty()) return 0
    val charCounter = IntArray(26)
    for (char in s) {
      charCounter[char - 'a']++
    }
    for (i in 0 until s.length) {
      if (charCounter[s[i] - 'a'] == 1) return i
    }
    return -1
  }
}
