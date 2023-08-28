package com.example.leetcode._Evaluate_Reverse_Polish_Notation

import java.util.*

class Solution {
  fun evalRPN(tokens: Array<String>): Int {
    val stack = Stack<Int>()
    for (token in tokens) {
      if (token != "+" && token != "-" && token != "*" && token != "/") {
        stack.pushConverted(token)
      } else {
        val second = stack.pop()
        val first = stack.pop()
        val result = when (token) {
          "+" -> first + second
          "-" -> first - second
          "*" -> first * second
          else -> first / second
        }
        stack.push(result)
      }
    }
    return stack.pop()
  }

  private fun Stack<Int>.pushConverted(number: String) {//можно .toInt() пользоваться!
    var result = 0
    var sign = 1
    for (char in number) {
      if (char == '-') {
        sign = -1
        continue
      }
      result = result * 10 + (char - '0')
    }
    this.push(sign * result)
  }
}
