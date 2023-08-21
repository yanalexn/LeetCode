package com.example.leetcode._Min_Stack

import org.junit.jupiter.api.Test

class MinStackTest {

  @Test
  fun `test my stack`() {
    val stack = MinStack()
    stack.push(3)
    println(stack.top())
    stack.pop()
    stack.push(4)
    println(stack.top())
    stack.pop()
    stack.push(5)
    stack.push(6)
    println(stack.getMin())
    stack.push(-1)
    println(stack.getMin())
    stack.pop()
    println(stack.getMin())
  }
}
