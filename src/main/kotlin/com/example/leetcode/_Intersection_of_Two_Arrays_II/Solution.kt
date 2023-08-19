package com.example.leetcode._Intersection_of_Two_Arrays_II

class Solution {
  /**
   * O(max(n, m))
   *
   * O(intersection(n, m))
   */
  fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val map = mutableMapOf<Int, IntArray>()
    for (i in 0..maxOf(nums1.size, nums2.size)) {
      if (i < nums1.size) {
        if (map[nums1[i]] == null) {
          map[nums1[i]] = intArrayOf(1, 0)
        } else {
          map[nums1[i]]!![0]++
        }
      }
      if (i < nums2.size) {
        if (map[nums2[i]] == null) {
          map[nums2[i]] = intArrayOf(0, 1)
        } else {
          map[nums2[i]]!![1]++
        }
      }
    }
    val result = mutableListOf<Int>()
    map.forEach {
      for (i in 0 until minOf(it.value[0], it.value[1]))
        result.add(it.key)
    }
    return result.toIntArray()
  }

  /**
   * Решение, которое быстрее меня, не намного умнее. Оно делает проходку по первому массиву, а во
   * время прохода по второму сразу добавляет нужные данные в конечный список и затем конвертирует его
   * в массив.
   */
  fun intersect2(nums1: IntArray, nums2: IntArray): IntArray {
    val temp = mutableMapOf<Int, Int>()
    val res: MutableList<Int> = mutableListOf()
    nums2.forEach {
      if (temp.contains(it)) {
        val counter = temp.getValue(it) + 1
        temp[it] = counter
      } else {
        temp[it] = 1
      }
    }
    nums1.forEach {
      if (temp.contains(it) && temp.getValue(it) > 0) {
        val counter = temp.getValue(it) - 1
        temp[it] = counter
        res.add(it)
      }
    }
    return res.toIntArray()
  }
}
