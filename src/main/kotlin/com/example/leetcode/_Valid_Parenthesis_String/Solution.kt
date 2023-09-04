package com.example.leetcode._Valid_Parenthesis_String

import java.util.*

class Solution {

  /**
   * Solution from NeetCode
   *
   * O(n)
   *
   * O(1)
   */
  fun checkValidString(s: String): Boolean {
    var leftMin = 0
    var leftMax = 0
    for (char in s) {
      when (char) {
        '(' -> {
          leftMin++
          leftMax++
        }
        ')' -> {
          leftMin--
          leftMax--
        }
        '*' -> {
          leftMin--
          leftMax++
        }
      }
      if (leftMin < 0) leftMin = 0
      if (leftMax < 0) return false
    }
    return leftMin == 0
  }

  fun checkValidString2(s: String): Boolean {
    val open = Stack<Int>()
    val star = Stack<Int>()


    for (i in s.indices){
      val c = s[i]

      when (c){
        '('  -> {
          open.push(i)
        }
        '*' -> {
          star.push(i)
        }
        else -> {
          //)
          if (open.isEmpty() && star.isEmpty()) return false

          if (open.isNotEmpty()){
            open.pop()
          }else{
            star.pop()
          }
        }
      }
    }

    while (open.isNotEmpty() && star.isNotEmpty()){
      if (open.pop() > star.pop()) return false
    }

    return open.isEmpty()
  }
}
