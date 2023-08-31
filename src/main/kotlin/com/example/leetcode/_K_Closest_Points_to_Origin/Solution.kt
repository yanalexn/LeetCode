package com.example.leetcode._K_Closest_Points_to_Origin

import java.util.*
import kotlin.Comparator

class Solution {

  /**
   * In PriorityQueue add(...) and poll() spend O(log n) time
   *
   * O(n log n)
   *
   * O(n)
   */
  fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
    val minHeap = PriorityQueue<IntArray>(
      Comparator<IntArray>() {
        a, b -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]
      }
    )
    for (point in points) {
      minHeap.add(point)
    }
    val result = Array<IntArray>(k) { IntArray(2) }
    repeat(k) {
      val temp = minHeap.poll()
      result[it] = temp
    }
    return result
  }

  /**
   * Idk why the following is the fastest solution, but here it is:
   */
  fun kClosest2(points: Array<IntArray>, k: Int): Array<IntArray> {
    val priorityQueue = PriorityQueue<IntArray>(Comparator { item1, item2 ->
      val res = calculateDistanceToZero(item2) - calculateDistanceToZero(item1)
      if(res > 0) 1 else -1
    })
    points.forEach {
      priorityQueue.add(it)
    }
    while(priorityQueue.size > k) {
      priorityQueue.poll()
    }
    val mutableList = mutableListOf<IntArray>()
    priorityQueue.forEach { mutableList.add(it) }

    val result = mutableList.toTypedArray()
    return result
  }

  fun calculateDistanceToZero(item: IntArray): Double {
    return Math.sqrt(
      Math.pow(item[0].toDouble(),2.0) +
        Math.pow(item[1].toDouble(),2.0)
    )
  }
}
