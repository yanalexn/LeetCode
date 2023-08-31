package com.example.leetcode._Last_Stone_Weight

import java.util.*
import kotlin.Comparator

class Solution {

  fun lastStoneWeight(stones: IntArray): Int {
    val maxHeap = PriorityQueue<Int>(Comparator.reverseOrder())
    for (stone in stones)
      maxHeap.add(stone)
    while (maxHeap.size > 1) {
      val diff = maxHeap.poll() - maxHeap.poll()
      if (diff != 0)
        maxHeap.add(diff)
    }
    return maxHeap.peek() ?: 0
  }
}
