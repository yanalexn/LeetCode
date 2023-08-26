package com.example.leetcode._Merge_Two_Sorted_Lists

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
   * O(n+m)
   *
   * O(1)
   */
  fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var temp1 = list1
    var temp2 = list2
    var result = list1 ?: list2
    while (temp1 != null && temp2 != null) {
      if (temp1.`val` <= temp2.`val`
        && (temp1.next == null || temp2.`val` <= temp1.next!!.`val`)) {
        val next1 = temp1.next
        val next2 = temp2.next
        temp1.next = temp2
        temp2.next = next1

        temp1 = temp1.next
        temp2 = next2
      } else if (temp1.`val` <= temp2.`val`
        && (temp1.next == null || temp2.`val` > temp1.next!!.`val`)) {
        temp1 = temp1.next
      } else if (temp1.`val` > temp2.`val`) {
        val next2 = temp2.next
        temp2.next = temp1

        temp1 = temp2
        temp2 = next2
        result = temp1
      }
    }
    return result
  }

  /**
   * coolest solution
   */
  fun mergeTwoLists2(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) return list2
    if (list2 == null) return list1

    return if (list1.`val` < list2.`val`) {
      list1.apply { next = mergeTwoLists(next, list2) }
    } else {
      list2.apply { next = mergeTwoLists(list1, next) }
    }
  }
}

class ListNode(var `val`: Int) {
  var next: ListNode? = null
}
