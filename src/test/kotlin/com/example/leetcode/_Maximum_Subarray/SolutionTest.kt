package com.example.leetcode._Maximum_Subarray

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SolutionTest {

    companion object {
        @JvmStatic
        fun getData(): List<Arguments> =
                listOf(
                        Arguments.of(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4), 6),
                        Arguments.of(intArrayOf(-2, 100, -300, 4, -1, 2, 1, -5, 4), 100),
                        Arguments.of(intArrayOf(100, -300, -300, 4), 100),
                )
    }

    private val solution = Solution()

    @ParameterizedTest
    @MethodSource("getData")
    fun maximize(nums: IntArray, expected: Int) {
        Assertions.assertEquals(expected, solution.maxSubArray(nums))
    }
}
