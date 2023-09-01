package com.example.leetcode._Merge_Intervals

class Solution {

  /**
   * O(n log n)
   *
   * O(n)
   */
  fun merge(intervals: Array<IntArray>): Array<IntArray> {
    intervals.sortWith { a, b -> a[0] - b[0] }//easier to use sortBy { it[0] }
    val result = mutableListOf(intervals[0])
    for (i in 1 until intervals.size) {
      result.last().run {
        if (this[0] <= intervals[i][0] && intervals[i][0] <= this[1]){
          this[0] = minOf(this[0], intervals[i][0])
          this[1] = maxOf(this[1], intervals[i][1])
        } else {
          result.add(intervals[i])
        }
      }
    }
    return result.toTypedArray()
  }
}
