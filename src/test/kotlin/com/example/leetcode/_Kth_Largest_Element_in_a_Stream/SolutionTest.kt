package com.example.leetcode._Kth_Largest_Element_in_a_Stream

import org.junit.jupiter.api.Test

class SolutionTest {

  @Test
  fun `test algorithm`() {
    val sol = KthLargest(3, intArrayOf(4, 5, 8, 2))
    println(sol.add(3))
    println(sol.add(5))
    println(sol.add(10))
    println(sol.add(9))
    println(sol.add(4))
  }
}
