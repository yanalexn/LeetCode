package com.example.leetcode._Palindrome_Linked_List

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
   * O(1)!!!!!
   */
  fun isPalindrome(head: ListNode?): Boolean {
    if (head?.next == null) return true
    var counter = 0
    var temp = head
    while (temp != null) {
      counter++
      temp = temp.next
    }
    var prev: ListNode? = null
    temp = head
    for (i in 0 until if (counter % 2 == 0) counter / 2 else counter / 2 + 1) {
      val next = temp?.next
      if (i < counter / 2) {
        temp?.next = prev
        prev = temp
      }
      temp = next
    }
    for (i in 0 until counter / 2) {
      if (temp?.`val` != prev?.`val`) return false
      temp = temp?.next
      prev = prev?.next
    }
    return true
  }
}

class ListNode(var `val`: Int) {
  var next: ListNode? = null
}
