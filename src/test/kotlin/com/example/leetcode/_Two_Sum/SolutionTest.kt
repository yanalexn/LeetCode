package com.example.leetcode._Two_Sum

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SolutionTest {

  companion object {
    @JvmStatic
    fun getData(): List<Arguments> =
      listOf(
        Arguments.of(intArrayOf(3, 2, 3), 6, intArrayOf(0, 2)),
      )
  }

  private val solution = Solution()

  @ParameterizedTest
  @MethodSource("getData")
  fun `test algorithm`(input: IntArray, target: Int, expected: IntArray) {
    Assertions.assertEquals(expected, solution.twoSum(input, target))
  }

  @Test
  fun `test IntArray initialization`() {
    val arr = IntArray(5) { it }
    println(arr.toList())
  }
}
