package com.example.leetcode._Reverse_Linked_List

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
   * O(n)
   *
   * O(1)
   */
  fun reverseList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var temp = head
    var next = head?.next
    while (temp != null) {
      temp.next = prev

      prev = temp
      temp = next
      next = next?.next
    }
    return prev
  }
}

class ListNode(var `val`: Int) {
  var next: ListNode? = null
}
