package com.example.leetcode._Valid_Parenthesis

/**
 * O(n)
 *
 * O(n)
 */
class Solution {

  private var tail: OpenBracket? = null

  private data class OpenBracket(
    var bracket: Char,
    var prev: OpenBracket? = null
  )

  fun isValid(s: String): Boolean {
    for (char in s) {
      when (char) {
        '(' -> tail = OpenBracket('(', tail)

        '{' -> tail = OpenBracket('{', tail)

        '[' -> tail = OpenBracket('[', tail)

        ')' -> tail = if (tail == null || tail!!.bracket != '(')
          return false
        else
          tail!!.prev

        '}' -> tail = if (tail == null || tail!!.bracket != '{')
          return false
        else
          tail!!.prev

        ']' -> tail = if (tail == null || tail!!.bracket != '[')
          return false
        else
          tail!!.prev
      }
    }
    return tail == null
  }
}
