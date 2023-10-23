package com.example.leetcode._Valid_Anagram

class Solution {
  /**
   * excellent performance!
   * O(n)
   * O(1)
   */
  fun isAnagram(s: String, t: String): Boolean {
    if (s == t) return true
    if (s.length != t.length) return false

    val sCharCounter = IntArray(26)
    val tCharCounter = IntArray(26)
    for (i in s.indices) {
      sCharCounter[s[i] - 'a']++
      tCharCounter[t[i] - 'a']++
    }
    for (i in 0..25) {
      if (sCharCounter[i] != tCharCounter[i]) return false
    }
    return true
  }
}
