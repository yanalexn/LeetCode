package com.example.leetcode._Reverse_Integer

class Solution {

  /**
   * O(n) - time complexity
   * O(n) - space complexity
   */
  fun reverse(x: Int): Int {
    var xCopy = x
    var result = 0L
    val list = ArrayList<Int>()
    while (xCopy != 0) {
      list.add(xCopy % 10)
      xCopy /= 10
    }
    for (i in list.indices) {
      result += 10.pow(list.size - 1 - i) * list[i]
    }
    return if (result > Int.MAX_VALUE) 0
    else if (result < Int.MIN_VALUE) 0
    else result.toInt()
  }

  fun Int.pow(i: Int): Long {
    return when {
      i == 0 -> 1
      i == 1 -> this.toLong()
      i % 2 == 0 -> (this * this).pow(i / 2)
      else -> (this * this).pow((i - 1) / 2) * this
    }
  }
}
