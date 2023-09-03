package com.example.leetcode._Partition_Labels

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SolutionTest {

  companion object {
    @JvmStatic
    fun data(): List<Arguments> =
      listOf(
        Arguments.of("ababcbacadefegdehijhklij", listOf(9, 7, 8)),
      )
  }

  private val solution = Solution()

  @ParameterizedTest
  @MethodSource("data")
  fun `test algorithm`(input: String, expected: List<Int>) {
    Assertions.assertEquals(expected, solution.partitionLabels(input))
  }
}
