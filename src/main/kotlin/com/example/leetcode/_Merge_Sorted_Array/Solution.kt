package com.example.leetcode._Merge_Sorted_Array

class Solution {
  /**
   * O(m + n)
   *
   * O(m)
   */
  fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    val copy = IntArray(m)
    for (i in 0 until m) {
      copy[i] = nums1[i]
    }
    var pointer1 = 0
    var pointer2 = 0
    var resultPointer = 0
    val sum = m + n
    while (resultPointer < sum) {
      if ((pointer1 < m && pointer2 < n && nums2[pointer2] <= copy[pointer1])
        || pointer1 >= m) {
        nums1[resultPointer] = nums2[pointer2]
        pointer2++
      } else {
        nums1[resultPointer] = copy[pointer1]
        pointer1++
      }

      resultPointer++
    }
  }

  /**
   * Much smarter solution: they don't copy the whole array. They do it backwards.
   *
   * O(m + n)
   *
   * O(1)
   */
  fun merge2(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var i = m - 1
    var j = n - 1
    var k = m + n - 1
    while (k >= 0) {
      if (i == -1 || (j > -1 && nums1[i] < nums2[j])) {
        nums1[k--] = nums2[j--]
      } else {
        nums1[k--] = nums1[i--]
      }
    }
  }
}
