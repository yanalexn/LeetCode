package com.example.leetcode._70_Climbing_Stairs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SolutionTest {

  companion object {
    @JvmStatic
    fun getData(): List<Arguments> =
      listOf(
        Arguments.of(1, 1),
        Arguments.of(2, 2),
        Arguments.of(3, 3),
        Arguments.of(4, 5),
        Arguments.of(5, 8),
        Arguments.of(6, 13),
        Arguments.of(7, 21),
        Arguments.of(8, 34),
        Arguments.of(9, 55),
        Arguments.of(10, 89),
        Arguments.of(11, 144),
        Arguments.of(12, 233),
        Arguments.of(13, 377),
        Arguments.of(18, 4181),
        Arguments.of(28, 514229),
        Arguments.of(45, 1836311903),
      )
  }

  private val solution = Solution()

  @ParameterizedTest
  @MethodSource("getData")
  fun `it is actually the Fibonacci sequence`(n: Int, expected: Int) {
    assertEquals(expected, solution.climbStairs(n))
  }
}
