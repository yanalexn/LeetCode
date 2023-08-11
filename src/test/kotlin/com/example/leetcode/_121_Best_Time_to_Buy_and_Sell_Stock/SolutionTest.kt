package com.example.leetcode._121_Best_Time_to_Buy_and_Sell_Stock

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SolutionTest {

  companion object {
    @JvmStatic
    fun getData(): List<Arguments> =
      listOf(
        Arguments.of(intArrayOf(7, 1, 5, 3, 6, 4), 5),
        Arguments.of(intArrayOf(7, 15, 1, 5, 3, 6, 4), 8),
        Arguments.of(intArrayOf(44, 60, 7, 15, 1, 5, 3, 6, 4), 16),
        Arguments.of(intArrayOf(44, 50, 60, 7, 15, 1, 5, 3, 6, 4), 16),
        Arguments.of(intArrayOf(44, 50, 33, 60, 7, 15, 1, 5, 3, 6, 4), 27),
      )
  }

  private val solution = Solution()

  @ParameterizedTest
  @MethodSource("getData")
  fun stocks(stocks: IntArray, expected: Int) {
    assertEquals(expected, solution.maxProfit(stocks))
  }
}
