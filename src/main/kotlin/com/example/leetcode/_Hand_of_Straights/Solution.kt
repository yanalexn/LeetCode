package com.example.leetcode._Hand_of_Straights

import java.util.*

class Solution {

  private data class MutablePair(
    var first: Int,
    var second: Int
  )

  /**
   * O(n log n)
   *
   * O(n)
   */
  fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
    if (hand.size % groupSize != 0) return false
    val minHeap = PriorityQueue<MutablePair> { a, b -> a.first - b.first }
    val countUnique = HashMap<Int, Int>()
    val group = Array(groupSize) { MutablePair(0, 0) }
    hand.forEach {
      countUnique[it] = countUnique.getOrDefault(it, 0) + 1
    }
    countUnique.forEach {
      minHeap.add(MutablePair(it.key, it.value))
    }
    val repetition = hand.size / groupSize
    repeat(repetition) {
      var prev = minHeap.poll()
      group[0] = prev
      repeat(groupSize - 1) { i ->
        val temp = minHeap.poll()
        if (temp == null || temp.first != prev.first + 1)
          return false
        group[i + 1] = temp
        prev = temp
      }
      group.forEach {
        it.apply {
          second--
          if (second != 0)
            minHeap.add(this)
        }
      }
    }
    return true
  }
}

