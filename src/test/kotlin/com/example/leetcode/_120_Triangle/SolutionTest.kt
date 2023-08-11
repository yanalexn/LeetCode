package com.example.leetcode._120_Triangle

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SolutionTest {

  companion object {
    @JvmStatic
    fun getData(): List<Arguments> =
      listOf(
        Arguments.of(listOf(listOf(3)), 3),
        Arguments.of(listOf(listOf(3), listOf(1, 2)), 4),
        Arguments.of(listOf(listOf(3), listOf(1, 2), listOf(4, 5, 1)), 6),
        Arguments.of(listOf(listOf(3), listOf(1, 2), listOf(4, 5, 1), listOf(1, 1, 5, 6)), 9),
        Arguments.of(listOf(listOf(3), listOf(1, 2), listOf(4, 5, 1), listOf(1, 1, 5, 6), listOf(5, 5, 4, 1, 7)), 12),
        Arguments.of(listOf(listOf(2), listOf(3, 4), listOf(5, 6, 7), listOf(4, 1, 8, 3)), 11)
      )
  }

  private val solution = Solution()

  @ParameterizedTest
  @MethodSource("getData")
  fun `increasing pyramid`(pyramid: List<List<Int>>, expected: Int) {
    assertEquals(expected, solution.minimumTotal(pyramid))
  }
}
