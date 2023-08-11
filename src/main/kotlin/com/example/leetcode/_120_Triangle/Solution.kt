package com.example.leetcode._120_Triangle

class Solution {

  fun minimumTotal(triangle: List<List<Int>>): Int {
    val memoryList = mutableListOf<Array<Int>>()
    memoryList.add(arrayOf(0, 0))
    var flag = true

    for (level in triangle.indices) {
      flag = !flag

      for (block in triangle[level].indices) {
        if (block == 0) {
          memoryList[block][flagIndex(flag)] =
            triangle[level][block] + memoryList[block][flagIndex(!flag)]
        } else if (memoryList.size <= block) {
          memoryList.add(arrayOf(0, 0))
          memoryList[block][flagIndex(flag)] =
            triangle[level][block] + memoryList[block - 1][flagIndex(!flag)]
        } else {
          memoryList[block][flagIndex(flag)] =
            triangle[level][block] +
                minOf(
                  memoryList[block - 1][flagIndex(!flag)],
                  memoryList[block][flagIndex(!flag)]
                )
        }
      }
    }

    return memoryList.minOf { it[flagIndex(flag)] }
  }

  private fun flagIndex(flag: Boolean) =
    if (flag) {
      0
    } else {
      1
    }

  private inline fun <T, R : Comparable<R>> Iterable<T>.minOf(selector: (T) -> R): R {
    val iterator = iterator()
    if (!iterator.hasNext()) throw NoSuchElementException()
    var minValue = selector(iterator.next())
    while (iterator.hasNext()) {
      val v = selector(iterator.next())
      if (minValue > v) {
        minValue = v
      }
    }
    return minValue
  }
}
