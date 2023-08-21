package com.example.leetcode._Shuffle_an_Array

import kotlin.random.Random

class Solution(private val nums: IntArray) {

  fun reset() = nums

  fun shuffle(): IntArray {
    val copy = nums.copyOf()
    var i = copy.size - 1
    while (i >= 0) {
      val randomI = Random.nextInt(i + 1)
      val temp = copy[i]
      copy[i] = copy[randomI]
      copy[randomI] = temp
      i--
    }
    return copy
  }

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(nums)
 * var param_1 = obj.reset()
 * var param_2 = obj.shuffle()
 */
