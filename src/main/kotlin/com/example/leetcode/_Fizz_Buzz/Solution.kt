package com.example.leetcode._Fizz_Buzz

class Solution {
  /**
   * O(n)
   *
   * O(1)
   */
  fun fizzBuzz(n: Int): List<String> {
    return List(n) {
      val i = it + 1
      when {
        i % 15 == 0 -> "FizzBuzz"
        i % 3 == 0 -> "Fizz"
        i % 5 == 0 -> "Buzz"
        else -> "$i"
      }
    }
  }
}
