package com.example.leetcode._My_Atoi

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
        Arguments.of("", 0),
        Arguments.of("     ", 0),
        Arguments.of("0", 0),
        Arguments.of("0001", 1),
        Arguments.of("   -012", -12),
        Arguments.of("  w^&1234", 0),
        Arguments.of("  -01w%\$1", -1),
        Arguments.of("42", 42),
      )
  }

  private val solution = Solution()

  @ParameterizedTest
  @MethodSource("getData")
  fun `test algorithm`(input: String, expected: Int) {
    Assertions.assertEquals(expected, solution.myAtoi(input))
  }

  @Test
  fun `test Char class`() {
    var s = "string"
    var char = s[0]
    var long = 0L + (char - '0') + 48
  }

  @Test
  fun `test StringBuilder`() {
    val sb = StringBuilder()
    var string = "string"
    sb.append(string[0])
    println("before:$sb-after")
  }
}
