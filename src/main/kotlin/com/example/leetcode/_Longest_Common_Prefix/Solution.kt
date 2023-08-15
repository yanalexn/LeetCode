package com.example.leetcode._Longest_Common_Prefix

class Solution {
  //"", ""
  //"asdf"
  //"asdf", "a"

  /**
   * From the first try~!
   *
   * O(n * size) - where n = strs.size, size = strs[0].length
   * O(n)
   */

  fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.size == 1)
      return strs[0]
    val result = StringBuilder()
    for (letterIndex in strs[0].indices) {
      val currentLetter = strs[0][letterIndex]
      for (wordIndex in 1 until strs.size) {
        if (letterIndex >= strs[wordIndex].length
          || currentLetter != strs[wordIndex][letterIndex])
          return result.toString()
      }
      result.append(currentLetter)
    }
    return result.toString()
  }
}
