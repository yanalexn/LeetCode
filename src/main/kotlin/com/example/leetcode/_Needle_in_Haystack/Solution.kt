package com.example.leetcode._Needle_in_Haystack

class Solution {

  /**
   * O(n-m) - time complexity
   * O(n-m) - space complexity
   */
  fun strStr(haystack: String, needle: String): Int {
    val needleSize = needle.length
    needle.contains("")
    needle[0]
    for (i in 0..haystack.length - needleSize) {
      if (haystack.substring(i, i + needleSize).equals(needle)) {
        return i
      }
    }
    return -1
  }
}
