package com.example.leetcode._Rotate_Array

class Solution {
  //[0,1,2,3,4,5,6,7], k = 3
  //last -> k-1 >= 0
  //last-1 -> k-2 >= 0
  //....
  //0 -> k < size
  //1 -> k+1 < size

  //7 -> 2 | (7+3)%8 = 2
  //6 -> 1
  //5 -> 0 | (5+3)%8 = 0
  //..
  //0 -> 3
  //1 -> 4
  //2 -> 5 | (2+3)%8 = 5

  /**
   * O(n)
   * O(n)
   */
  fun rotateInitial(nums: IntArray, k: Int): IntArray {
    val size = nums.size
    if (k % size == 0 || size == 1)
      return nums

    val result = IntArray(size)
    for (i in nums.indices) {
      result[(i + k) % size] = nums[i]
    }
    return result
  }

  /**
   * O(n)
   * O(1)
   */
  fun rotate(nums: IntArray, k: Int): Unit {
    val size = nums.size
    if (k % size == 0)
      return

    for (i in 0 until gcd(size, k)) {
      var tempIndex = i
      var prevValue = nums[i]
      do {
        tempIndex = (tempIndex + k) % size
        val curValue = nums[tempIndex]
        nums[tempIndex] = prevValue
        prevValue = curValue
      } while (tempIndex != i)
    }
  }

  private fun gcd(a: Int, b: Int): Int{
    return if (a == 0)
      b
    else
      gcd(b % a, a)
  }
}
