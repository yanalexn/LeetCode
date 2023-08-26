package com.example.leetcode._Merge_Sorted_Array

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SolutionTest {

  companion object {
    @JvmStatic
    fun data(): List<Arguments> =
      listOf(
        Arguments.of(
          intArrayOf(1, 2, 3, 0, 0, 0),
          3,
          intArrayOf(2, 5, 6),
          3,
          intArrayOf(1, 2, 2, 3, 5, 6)),
      )
  }

  private val solution = Solution()

  @ParameterizedTest
  @MethodSource("data")
  fun `test algorithm`(nums1: IntArray, m: Int, nums2: IntArray, n: Int, expected: IntArray) {
    solution.merge(nums1, m, nums2, n)
    Assertions.assertArrayEquals(expected, nums1)
  }
}
