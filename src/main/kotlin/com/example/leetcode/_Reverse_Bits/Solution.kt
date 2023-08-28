package com.example.leetcode._Reverse_Bits

class Solution {
  // you need treat n as an unsigned value
  fun reverseBits(n: Int): Int {
    var result = 0
    for (i in 0..31) {
      result = result shl 1
      result += (n ushr i) and 1
    }
    return result
  }
}
