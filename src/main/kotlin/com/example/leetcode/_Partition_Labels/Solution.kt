package com.example.leetcode._Partition_Labels

class Solution {

  /**
   * O(n^2) in the worst case
   *
   * O(1) ~ O(26)
   */
  fun partitionLabels(s: String): List<Int> {
    val set = HashSet<Char>()
    val result = mutableListOf<Int>()
    var prev = 0
    var end = 1
    var i = 0
    while (i < s.length) {
      while (i < end) {
        if (set.add(s[i])) {
          var j = s.length - 1
          while (s[j] != s[i]) {
            j--
          }
          end = maxOf(end, j + 1)
          if (end == s.length) {
            result.add(end - prev)
            return result
          }
        }
        i++
      }
      result.add(end - prev)
      if (end == s.length)
        break
      prev = end
      end++
    }
    return result
  }

  /**
   * O(n) solution
   */
  fun partitionLabels2(s: String): List<Int> {

    val array = IntArray(26)
    for ((i, c) in s.withIndex()) {
      array[c - 'a'] = Math.max(array[c - 'a'], i)
    }
    val result = mutableListOf<Int>()
    var lastIndex = 0
    var prevIndex = -1
    for ((i, c) in s.withIndex()) {
      lastIndex = Math.max(array[c - 'a'], lastIndex)
      if (i == lastIndex){
        result.add(lastIndex - prevIndex)
        prevIndex = lastIndex
      }

    }
    return result
  }
}
