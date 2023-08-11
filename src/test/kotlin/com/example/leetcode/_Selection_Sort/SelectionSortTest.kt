package com.example.leetcode._Selection_Sort

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SelectionSortTest {

  companion object {
    @JvmStatic
    fun getData(): List<Arguments> =
      listOf(
        Arguments.of(
          intArrayOf(2, 1),
          intArrayOf(1, 2)
        ),
        Arguments.of(
          intArrayOf(8, 6, 4, 3),
          intArrayOf(3, 4, 6, 8)
        ),
        Arguments.of(
          intArrayOf(6, 4, 3, -8),
          intArrayOf(-8, 3, 4, 6)
        ),
      )
  }

  private val selectionSort = SelectionSort()

  @ParameterizedTest
  @MethodSource("getData")
  fun maximize(inputArr: IntArray, expected: IntArray) {
    assertArrayEquals(expected, selectionSort.sort(inputArr))
  }
}
