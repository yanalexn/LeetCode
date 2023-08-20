package com.example.leetcode._Count_Primes

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.math.sqrt

class SolutionTest {

  companion object {
    @JvmStatic
    fun getData(): List<Arguments> =
      listOf(
        Arguments.of(10, 4),
      )
  }

  private val solution = Solution()

  @ParameterizedTest
  @MethodSource("getData")
  fun `test algorithm`(input: Int, expected: Int) {
    assertEquals(expected, solution.countPrimes(input))
  }
}
