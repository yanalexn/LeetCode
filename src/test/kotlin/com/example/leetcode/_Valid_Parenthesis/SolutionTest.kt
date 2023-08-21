package com.example.leetcode._Valid_Parenthesis

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SolutionTest {

  private val solution = Solution()

  companion object {
    @JvmStatic
    fun data(): List<Arguments> =
      listOf(
        Arguments.of("()", true),
        Arguments.of("({})", true),
        Arguments.of("(){})", false),
        Arguments.of("(){}", true),
      )
  }

  @ParameterizedTest
  @MethodSource("data")
  fun `test algorithm`(input: String, expected: Boolean) {
    solution.apply {
      assertEquals(expected, isValid(input))
    }
  }

  private data class Wrap(var int: Int)

  @Test
  fun `Kotlin scope functions`() {
    val wrap = Wrap(1)
    println("Original wrap = $wrap")
    wrap.apply { int = 2 }
    println("New wrap = $wrap")
    wrap.also { it.int = 32 }
    println("New wrap = $wrap")
    wrap.let { it.int = 69 }
    println("New wrap = $wrap")
    wrap.run { this.int = 15 }
    println("New wrap = $wrap")
    run { wrap.int = 89 }
    println("New wrap = $wrap")
    with(wrap) { this.int = 100 }
    println("New wrap = $wrap")
    val value = with(wrap) { this.int = 1000 }
    println("Value = $value")
  }
}
