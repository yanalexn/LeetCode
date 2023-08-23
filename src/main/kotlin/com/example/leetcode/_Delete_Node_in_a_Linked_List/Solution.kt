package com.example.leetcode._Delete_Node_in_a_Linked_List

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {

  /**
   * Cool trick: we do not delete the given node, but delete the node next to it, copy value to the
   * given node and pretend that we deleted the current node.
   *
   * O(1)
   *
   * O(1)
   */
  fun deleteNode(node: ListNode) {
    node.`val` = node.next!!.`val`
    node.next = node.next!!.next
  }
}

class ListNode(var `val`: Int) {
  var next: ListNode? = null
}
