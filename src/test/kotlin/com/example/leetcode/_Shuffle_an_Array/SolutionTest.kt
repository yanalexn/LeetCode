package com.example.leetcode._Shuffle_an_Array

import org.junit.jupiter.api.Test
import java.util.*

class SolutionTest {

  private val solution = Solution(intArrayOf(-6, 10, 184))

  @Test
  fun `test algorithm`() {
    println(solution.reset().contentToString())
    println(solution.shuffle().contentToString())
    println(solution.reset().contentToString())
    println(solution.shuffle().contentToString())
    println(solution.reset().contentToString())
  }
}
