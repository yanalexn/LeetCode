package com.example.leetcode._Remove_Nth_Node_from_End_of_List

import com.example.leetcode._Delete_Node_in_a_Linked_List.ListNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

//

class Solution {

  /**
   * O(n)
   *
   * O(1)
   */
  fun removeNthFromEnd(head: ListNode, n: Int): ListNode? {
    if (head.next == null) return null
    var nStepsBehindPointer = -n
    var firstNext: ListNode? = head
    var nStepsBehindNext: ListNode? = null
    while (firstNext != null) {
      if (nStepsBehindPointer == 0) {
        nStepsBehindNext = head
      }
      nStepsBehindPointer++
      firstNext = firstNext.next
      if (firstNext == null) break
      nStepsBehindNext = nStepsBehindNext?.next
    }
    nStepsBehindNext?.apply {
      next = nStepsBehindNext.next?.next
    } ?: return head.next
    return head
  }
}

class ListNode(var `val`: Int) {
  var next: ListNode? = null
}
