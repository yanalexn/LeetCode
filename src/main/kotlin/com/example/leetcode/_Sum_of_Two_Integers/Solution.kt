package com.example.leetcode._Sum_of_Two_Integers

class Solution {
  fun getSum(a: Int, b: Int): Int {
    var prev = 0
    var result = 0
    for (i in 0..31) {
      val ai = (a ushr i) and 1
      val bi = (b ushr i) and 1
      val temp = ai xor bi xor prev
      prev = (ai and bi) or (bi and prev) or (prev and ai)
      result = result or (temp shl i)
    }
    return result
  }

  /**
   * I don't even understand my own my solution. But THIS solution is out of this world!
   */
  fun getSum2(a: Int, b: Int): Int {
    var first = a
    var second = b
    while (second != 0) {
      var temp = first xor second
      second = (second and first) shl 1
      first = temp
    }
    return first
  }
}
