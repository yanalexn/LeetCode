package com.example.leetcode._1799_Maximize_Score_After_N_Operations

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SolutionTest {

    companion object {
        @JvmStatic
        fun getData(): List<Arguments> =
                listOf(
                        Arguments.of(intArrayOf(1, 2), 1),
                        Arguments.of(intArrayOf(3, 4, 6, 8), 11),
                        Arguments.of(intArrayOf(1, 2, 3, 4, 5, 6), 14),
                        Arguments.of(intArrayOf(109497,983516,698308,409009,310455,528595,524079,18036,341150,641864,913962,421869,943382,295019), 527),
//                        Arguments.of(intArrayOf(44, 50, 33, 60, 7, 15, 1, 5, 3, 6, 4), 27),
                )
    }

    private val solution = Solution()

    @ParameterizedTest
    @MethodSource("getData")
    fun maximize(nums: IntArray, expected: Int) {
        Assertions.assertEquals(expected, solution.maxScore(nums))
    }
}
