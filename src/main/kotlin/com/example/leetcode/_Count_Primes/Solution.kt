package com.example.leetcode._Count_Primes

import kotlin.math.sqrt

class Solution {
  /**
   * O(n^2) - time limit exceeded - super slow
   *
   * O(n)
   */
  fun countPrimes1(n: Int): Int {
    if (n == 0 || n == 1) return 0
    else if (n == 2) return 1

    val numbers = MutableList(n - 2) { it + 2 }
    var i = 1
    var prime = 2
    while (prime <= sqrt(n.toDouble()).toInt()) {
      var j = i
      while (j < numbers.size) {
        if (numbers[j] % prime == 0) {
          numbers.removeAt(j)
        } else {
          j++
        }
      }
      prime = numbers[i]
      i++
    }
    return numbers.size
  }

  /**
   * O(n^2) - slow anyway (n + n-1 + ... sqrt(n)) ~ n^2 + n ~ n^2
   */
  fun countPrimes(n: Int): Int {
    if (n <= 2) return 0

    val numbers = IntArray(n - 2) { it + 2 }
    var i = 0
    var prime = 2
    while (prime <= sqrt(n.toDouble()).toInt()) {
      if (numbers[i] == 0 || prime == 0) {
        i++
        prime = numbers[i]
        continue
      }
      for (j in i + 1 until numbers.size) {
        if (numbers[j] == 0) continue
        if (numbers[j] % prime == 0) {
          numbers[j] = 0
        }
      }

      i++
      prime = numbers[i]
    }
    return countNonZero(numbers)
  }

  private fun countNonZero(numbers: IntArray): Int {
    var counter = 0
    numbers.forEach { if (it != 0) counter++ }
    return counter
  }

  /**
   * The fastest solution
   */
  fun countPrimes3(n: Int): Int {
    if (n < 2) {
      return 0
    }

    val flags = BooleanArray(n - 2) {
      true
    }

    for (i in 2..Math.sqrt(n.toDouble()).toInt()) {
      if (flags[i - 2]) {
        for (j in i * i..n - 1 step i) {
          flags[j - 2] = false
        }
      }
    }

    var count = 0
    for (f in flags) {
      if (f) {
        count++
      }
    }

    return count
  }
















  ////////////////////////////////////////////////////////////
  /*private */operator fun compareTo(solution: Solution/*Any class*/): Int {
    TODO()
  }

  private fun hello() {
    val sol1 = Solution()
    val sol2 = Solution()
    var comp = sol1 > sol2// Kotlin super cool feature
  }
}
