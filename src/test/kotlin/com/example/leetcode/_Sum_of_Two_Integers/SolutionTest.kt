package com.example.leetcode._Sum_of_Two_Integers

import com.example.leetcode._Number_of_1_Bits.SolutionTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SolutionTest {

  companion object {
    @JvmStatic
    fun data(): List<Arguments> =
      listOf(
        Arguments.of(1, 2, 3),
        Arguments.of(10, 12, 22),
        Arguments.of(-1, 2, 1),
        Arguments.of(-1, -2, -3),
        Arguments.of(-1, 1, 0),
        Arguments.of(-1, -1, -2),
      )
  }

  private val solution = Solution()

  @ParameterizedTest
  @MethodSource("data")
  fun `test algorithm`(a: Int, b: Int, expected: Int) {
    println(SolutionTest.toBinary(a))
    println(SolutionTest.toBinary(b))
    println(SolutionTest.toBinary(expected))
    assertEquals(expected, solution.getSum(a, b))
  }

  @Test
  fun `test binary representation again`() {
    println(SolutionTest.toBinary(Int.MIN_VALUE))
    println(SolutionTest.toBinary(Int.MIN_VALUE + 1))
    println(SolutionTest.toBinary(-1))
    println(SolutionTest.toBinary(Int.MAX_VALUE))
  }
}

