package com.example.leetcode._Kth_Largest_Element_in_an_Array

import java.util.*
import kotlin.Comparator

class Solution {

  /**
   * Using priority queue
   *
   * O(n log n)
   *
   * O(n)
   */
  fun findKthLargest(nums: IntArray, k: Int): Int {
    val maxHeap = PriorityQueue<Int>(Comparator.reverseOrder())
    nums.forEach {
      maxHeap.add(it)
    }
    repeat (k - 1) {
      maxHeap.poll()
    }
    return maxHeap.peek()
  }

  /**
   * the second solution via the quick selection algorithm
   *
   * O(n) - in average - O(n^2) in the worst case
   *
   * O(1)
   */
  fun findKthLargest2(nums: IntArray, k: Int): Int {
    val target = nums.size - k
    return quickSelect(nums, target)
  }

  private fun quickSelect(nums: IntArray, target: Int, start: Int = 0, end: Int = nums.size - 1): Int {
    var pivot = start
    for (i in start..end - 1) {
      if (nums[i] <= nums[end]) {
        nums.swap(i, pivot)
        pivot++
      }
    }
    nums.swap(end, pivot)
    return if (pivot == target) nums[pivot]
    else if (pivot > target) quickSelect(nums, target, start, --pivot)
    else quickSelect(nums, target, ++pivot, end)

  }

  private fun IntArray.swap(i: Int, j: Int) {
    this[i] = this[j].also { this[j] = this[i] }
  }
}
