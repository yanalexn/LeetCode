package com.example.leetcode._Task_Scheduler

import java.util.*
import kotlin.Comparator

class Solution {

  /**
   * Can't solve this task yet.
   *
   * Keywords (which I don't understand yet): Heap, Priority queue
   *
   * And now I can
   */
  fun leastInterval(tasks: CharArray, n: Int): Int {
    var count = 0
    var taskBackwardCount = tasks.size
    val period = IntArray(n + 1)
    val uniqueTasks = IntArray(26)
    val maxHeap = PriorityQueue<Int>(Comparator.reverseOrder())
    tasks.forEach {
      uniqueTasks[it - 'A']++
    }
    uniqueTasks.filter { it != 0 }
      .forEach {
        maxHeap.add(it)
      }
    while (maxHeap.isNotEmpty()) {
      var i = 0
      while (i < n + 1 && taskBackwardCount > 0) {
        maxHeap.poll()?.run {
          period[i] = this - 1
          taskBackwardCount--
        } ?: run {
          count++
          period[i] = 0
        }
        i++
        if (taskBackwardCount == 0)
          return tasks.size + count
      }
      period.filter { it != 0 }
        .forEach { maxHeap.add(it) }
    }

    return tasks.size + count
  }

  /**
   * I don't understand the following code; so we're gonna test it
   */
  fun leastInterval2(tasks: CharArray, n: Int): Int {
    val freq = IntArray(26)
    for (task in tasks) ++freq[task.hashCode() - 'A'.hashCode()]
    Arrays.sort(freq)
    val maxFreq = freq[25] - 1
    var idleSlots = maxFreq * n
    for (i in 24 downTo 0) {
      if (freq[i] > 0)
        idleSlots -= Math.min(maxFreq, freq[i])
      else break
    }
    return if (idleSlots > 0) idleSlots + tasks.size else tasks.size
  }
}
