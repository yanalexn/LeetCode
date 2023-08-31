package com.example.leetcode._Kth_Largest_Element_in_a_Stream

import java.util.*

class KthLargest(
  private val k: Int,
  nums: IntArray
) {

  private val pq = PriorityQueue<Int>()//min heap

  init {
    for (num in nums)
      pq.add(num)
  }

  fun add(`val`: Int): Int {
    pq.add(`val`)
    while (pq.size > k) {
      pq.poll()
    }
    return pq.peek()
  }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */
