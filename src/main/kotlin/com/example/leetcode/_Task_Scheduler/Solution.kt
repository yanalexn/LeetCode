package com.example.leetcode._Task_Scheduler

import java.util.LinkedList

class Solution {

  /**
   * Can't solve this task yet.
   *
   * Keywords (which I don't understand yet): Heap, Priority queue
   */
  fun leastInterval(tasks: CharArray, n: Int): Int {
    var result = 0
    val taskCounter = IntArray(26)
    val taskOrder = LinkedList<Int>()
    for (task in tasks) {
      taskCounter[task - 'A']++
    }
    taskCounter.sort()

    return result
  }
}
