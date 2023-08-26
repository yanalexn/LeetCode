package com.example.leetcode._Convert_Sorted_Array_to_Binary_Search_Tree

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
  fun sortedArrayToBST(nums: IntArray, start: Int = 0, end: Int = nums.size): TreeNode? {
    val diff = end - start
    if (diff <= 0) return null
    val half = diff / 2
    val middle = start + half
    val root = TreeNode(nums[middle])
    root.left = sortedArrayToBST(nums, start, middle)
    root.right = sortedArrayToBST(nums, middle + 1, end)
    return root
  }
}

class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}
