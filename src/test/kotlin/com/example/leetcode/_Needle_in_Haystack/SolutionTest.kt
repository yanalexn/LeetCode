package com.example.leetcode._Needle_in_Haystack

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
        Arguments.of("sadbutsad", "sad", 0),
        Arguments.of("haystack", "needle", -1),
        Arguments.of("haystack", "needlexxxxxxx", -1),
        Arguments.of("haysadhay", "sad", 3),
      )
  }

  private val solution = Solution()

  @ParameterizedTest
  @MethodSource("getData")
  fun `test algorithm`(haystack: String, needle: String, expected: Int) {
    Assertions.assertEquals(expected, solution.strStr(haystack, needle))
  }

  @Test
  fun `test for loop`() {
    print("gonna print")
    for (i in 0..-3) {
      println(i)
    }
    print(" nothing")

    val charCounter = MutableList(26) {0}
    charCounter[0]++
    println(charCounter[0])
    val anotherCharCounter = MutableList(26) {0}
    anotherCharCounter[0]++
    println(charCounter == anotherCharCounter)
  }
}
