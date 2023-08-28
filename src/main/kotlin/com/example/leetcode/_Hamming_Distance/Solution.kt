package com.example.leetcode._Hamming_Distance

class Solution {

  /**
   * O(max(log n, log m)) - не будет превосходить 32 повторений, так что можно считать O(1)
   *
   * O(1)
   */
  fun hammingDistance(x: Int, y: Int): Int {
    var first = x
    var second = y
    var counter = 0
    while (first != 0 || second != 0) {
      counter += (first and 1) xor (second and 1)
      first = first ushr 1
      second = second ushr 1
    }
    return counter
  }

  /**
   * Basically the same, but slightly better
   */
  fun hammingDistance2(x: Int, y: Int): Int {
    var numBits = 0
    for (i in 0 until 32) {
      var xBit = ((x shr i) and 1)
      var yBit = ((y shr i) and 1)
      if (xBit != yBit) {
        numBits += 1
      }
    }
    return numBits
  }
}
/*
* 1111 1111 1111 1111 1111 1111 1111 1101
* */
