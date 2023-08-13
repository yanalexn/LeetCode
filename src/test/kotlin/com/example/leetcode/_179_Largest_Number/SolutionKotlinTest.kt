package com.example.leetcode._179_Largest_Number

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SolutionKotlinTest {
  companion object {
    @JvmStatic
    fun getData(): List<Arguments> =
      listOf(
        Arguments.of(intArrayOf(10, 2), "210"),
        Arguments.of(intArrayOf(3, 30, 34, 5, 9), "9534330"),
        Arguments.of(intArrayOf(0, 0, 0), "0"),
        Arguments.of(intArrayOf(3, 33, 34), "34333"),
      )
  }

  private val solution = SolutionKotlin()

  @ParameterizedTest
  @MethodSource("getData")
  fun largestNumber(nums: IntArray, expected: String) {
    assertEquals(expected, solution.largestNumber(nums))
  }

  @Test
  fun `how comparator works`() {
    println(solution.LargerNumberComparator().compare("33", "3"))// 0
    println(solution.LargerNumberComparator().compare("30", "3"))// >0
  }
}
