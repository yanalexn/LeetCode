package com.example.leetcode._Reverse_Integer

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.math.pow

class SolutionTest {

  companion object {
    @JvmStatic
    fun getData(): List<Arguments> =
      listOf(
        Arguments.of(123, 321),
        Arguments.of(1534236469, 0),
        Arguments.of(-123, -321),
        Arguments.of(-2147483648, 0),
      )

    @JvmStatic
    fun getDataForAuxFun(): List<Arguments> =
      listOf(
        Arguments.of(0, 1L),
        Arguments.of(1, 10L),
        Arguments.of(2, 100L),
        Arguments.of(3, 1000L),
      )
  }

  private val solution = Solution()

  @ParameterizedTest
  @MethodSource("getData")
  fun `test algorithm`(input: Int, expected: Int) {
    assertEquals(expected, solution.reverse(input))
  }

  @ParameterizedTest
  @MethodSource("getDataForAuxFun")
  fun `test auxiliary function`(input: Int, expected: Long) {
    with(solution) { assertEquals(10.pow(input), expected) }
  }

  @Test
  fun `out of bounds integer`() {
    val d = 2.0
    println(d.pow(31) - Int.MAX_VALUE)
    println(d.pow(32) - Int.MAX_VALUE)
  }
}
