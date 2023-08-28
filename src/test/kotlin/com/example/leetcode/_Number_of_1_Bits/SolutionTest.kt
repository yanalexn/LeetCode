package com.example.leetcode._Number_of_1_Bits

import org.junit.jupiter.api.Test

class SolutionTest {

  /**
   * Left shifting is equivalent to multiplying by 2 (more precisely, the power of 2)
   * Right shifting is equivalent to dividing by 2 (more precisely, the power of 2)
   */
  @Test
  fun `test bitwise operations`() {
    println("${5 shl 1}") // 10
    println("${5 shr 1}") // 2
    println("${5 shr 2}") // 1
    println("${5 shr 3}") // 0
  }

  @Test
  fun `test number to binary representation`() {
    println(toBinary(5))
    println(toBinary(3))
    println(toBinary(8))
    println(toBinary(-3))
  }

  companion object {
    fun toBinary(n: Int): String {
      var copy = n
      val sb = StringBuilder()
      while (copy != 0) {
        if (copy and 1 > 0) {
          sb.append("1")
        } else {
          sb.append("0")
        }
        copy = copy ushr 1
      }
      return sb.toString().reversed()
    }
  }
}
