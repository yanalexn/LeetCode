package com.example.leetcode._Merge_Intervals

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SolutionTest {

  companion object {
    @JvmStatic
    fun data(): List<Arguments> =
      listOf(
        Arguments.of(
          arrayOf(intArrayOf(1, 2), intArrayOf(0, 2), intArrayOf(5, 6)),
          arrayOf(intArrayOf(0, 2), intArrayOf(5, 6))
        ),
      )
  }

  private val solution = Solution()

  @ParameterizedTest
  @MethodSource("data")
  fun maximize(input: Array<IntArray>, expected: Array<IntArray>) {
    Assertions.assertArrayEquals(expected, solution.merge(input))
  }
}
