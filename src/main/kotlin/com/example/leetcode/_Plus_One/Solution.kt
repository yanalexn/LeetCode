package com.example.leetcode._Plus_One

class Solution {

  /**
   * O(n)
   *
   * O(n) in worst scenario, O(1) in average or best-case scenario
   */
  fun plusOne(digits: IntArray): IntArray {
    var next = 1
    var i = digits.size - 1
    while (next != 0 && i >= 0) {
      if (digits[i] != 9){
        digits[i] += next
        next = 0
      }
      else {
        digits[i] = 0
      }
      i--
    }
    return if (next == 1) {
      IntArray(digits.size + 1) { if (it == 0) 1 else digits[it - 1]}
    } else {
      digits
    }
  }

  //a little optimization:
  fun plusOne2(digits: IntArray): IntArray {
    val n = digits.size
    for (i in n - 1 downTo 0) {
      if (digits[i] < 9) {
        digits[i]++
        return digits
      }
      digits[i] = 0
    }
    val newDigits = IntArray(n + 1)
    newDigits[0] = 1
    return newDigits
  }
}
