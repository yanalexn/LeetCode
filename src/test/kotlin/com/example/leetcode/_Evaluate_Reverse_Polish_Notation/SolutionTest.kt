package com.example.leetcode._Evaluate_Reverse_Polish_Notation

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SolutionTest {

  companion object {
    @JvmStatic
    fun data(): List<Arguments> =
      listOf(
        Arguments.of(arrayOf("3", "4", "-"), -1),
        Arguments.of(arrayOf("2", "1", "+", "3", "*"), 9),
      )
  }

  private val solution = Solution()

  @ParameterizedTest
  @MethodSource("data")
  fun `test algorithm`(input: Array<String>, expected: Int) {
    Assertions.assertEquals(expected, solution.evalRPN(input))
  }
}
