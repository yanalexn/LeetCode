package com.example.leetcode._Insert_Interval

class Solution {
  fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    if (intervals.isEmpty()) return arrayOf<IntArray>(newInterval)
    val result = mutableListOf<IntArray>()
    if (intervals[0][0] > newInterval[1]) {
      result.add(newInterval)
      result.addAll(intervals)
      return result.toTypedArray()
    } else if (intervals.last()[1] < newInterval[0]) {
      result.addAll(intervals)
      result.add(newInterval)
      return result.toTypedArray()
    }
    var isStartingToMod = true
    for (i in intervals.indices) {
      when {
        i <= intervals.size - 2
          && intervals[i][1] < newInterval[0]
          && newInterval[1] < intervals[i + 1][0] -> {
          result.add(intervals[i])
          result.add(newInterval)
        }

        intervals[i][1] < newInterval[0] || intervals[i][0] > newInterval[1] -> result.add(intervals[i])

        isStartingToMod -> {
          result.add(intervals[i])
          result.last()[0] = minOf(intervals[i][0], newInterval[0])
          result.last()[1] = maxOf(intervals[i][1], newInterval[1])
          isStartingToMod = false
        }

        else -> result.last()[1] = maxOf(intervals[i][1], newInterval[1])
      }
    }
    return result.toTypedArray()
  }
}
