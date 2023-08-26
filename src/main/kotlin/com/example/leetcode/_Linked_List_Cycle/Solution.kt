package com.example.leetcode._Linked_List_Cycle

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
   * The tortoise and hare algorithm
   * O(n)
   *
   * O(1)
   */
  fun hasCycle(head: ListNode?): Boolean {
    var tortoise = head?.next?.next
    var hare = head?.next
    while (tortoise != null && hare != null) {
      if (tortoise == hare) return true
      tortoise = tortoise?.next?.next
      hare = hare?.next
    }
    return false
  }
}

class ListNode(var `val`: Int) {
  var next: ListNode? = null
}
