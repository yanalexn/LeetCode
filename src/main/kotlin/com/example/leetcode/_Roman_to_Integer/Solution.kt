package com.example.leetcode._Roman_to_Integer

class Solution {

  /**
   * O(n)
   *
   * O(1)
   */
  fun romanToInt(s: String): Int {
    var result = 0
    var i = 0
    while (i < s.length) {
      when (s[i]) {
        'I' -> if (i <= s.length - 2 && s[i + 1] == 'V') {
          i += 2
          result += 4
        } else if (i <= s.length - 2 && s[i + 1] == 'X') {
          i += 2
          result += 9
        } else {
          i++
          result += 1
        }
        'V' -> {
          i++
          result += 5
        }
        'X' -> if (i <= s.length - 2 && s[i + 1] == 'L') {
          i += 2
          result += 40
        } else if (i <= s.length - 2 && s[i + 1] == 'C') {
          i += 2
          result += 90
        } else {
          i++
          result += 10
        }
        'L' -> {
          i++
          result += 50
        }
        'C' -> if (i <= s.length - 2 && s[i + 1] == 'D') {
          i += 2
          result += 400
        } else if (i <= s.length - 2 && s[i + 1] == 'M') {
          i += 2
          result += 900
        } else {
          i++
          result += 100
        }
        'D' -> {
          i++
          result += 500
        }
        else -> {
          i++
          result += 1000
        }
      }
    }
    return result
  }
}
