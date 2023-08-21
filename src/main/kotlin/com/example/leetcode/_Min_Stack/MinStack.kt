package com.example.leetcode._Min_Stack

/**
 * Requirement: every operation must spend O(1) time
 *
 * O(n) space
 */
class MinStack {

  private var tail: Node? = null
  private var counter = 0

  /*as I noticed from the solution from NeetCode, you can remove counter and
  use tail == null as a checker
  */
  private data class Node(
    val value: Int,
    val prev: Node? = null,
    val min: Int
  )

  fun push(value: Int) {
    counter++
    val minValue = if (counter == 1) value else minOf(tail!!.min, value)
    tail = Node(value, tail, minValue)
  }

  fun pop() {
    counter--
    tail = if (counter != 0) tail!!.prev else null
  }

  fun top() = tail!!.value

  fun getMin() = tail!!.min
}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
