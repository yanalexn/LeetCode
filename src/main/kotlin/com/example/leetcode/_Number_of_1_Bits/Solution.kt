package com.example.leetcode._Number_of_1_Bits

class Solution {
  // you need treat n as an unsigned value
  fun hammingWeight(n: Int): Int {
    var copy = n
    var counter = 0
    while (copy != 0) {
      counter += copy and 1
      copy = copy ushr 1
    }
    return counter
  }
}
