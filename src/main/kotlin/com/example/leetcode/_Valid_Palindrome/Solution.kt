package com.example.leetcode._Valid_Palindrome

class Solution {

  /**
   * My first intention was to use [String.equals] with ignoreCase = true, but it turns out that using built-in
   * functions in general slows down your algorithm
   * O(n)
   * O(1)
   */
  fun isPalindrome(s: String): Boolean {
    var i = 0
    var j = s.length - 1
    while (i < j) {
      if (!isAlphaNumricChar(s[i])) i++
      else if (!isAlphaNumricChar(s[j])) j--
      else if (isAlphaNumricChar(s[i]) && isAlphaNumricChar(s[j])) {
        if (isUpperCase(s[i]) && isUpperCase(s[j]) && s[i] != s[j]
          || (isUpperCase(s[i]) && !isUpperCase(s[j]) && s[i] + 32 != s[j])
          || (!isUpperCase(s[i]) && isUpperCase(s[j]) && s[i] != s[j] + 32)
          || (!isUpperCase(s[i]) && !isUpperCase(s[j]) && s[i] != s[j])) return false
        i++
        j--
      }
    }
    return true
  }

  private fun isAlphaNumricChar(char: Char) =
    char in '0'..'9'
      || isUpperCase(char)
      || isLowerCase(char)

  private fun isUpperCase(char: Char) = char in 'A'..'Z'

  private fun isLowerCase(char: Char) = char in 'a'..'z'
}
