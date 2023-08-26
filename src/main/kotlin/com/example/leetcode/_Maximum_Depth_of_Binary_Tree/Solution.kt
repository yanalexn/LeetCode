package com.example.leetcode._Maximum_Depth_of_Binary_Tree

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

  /**
   * O(n)
   *
   * O(1)
   */
  fun maxDepth(root: TreeNode?): Int {
    return if (root == null) 0
    else maxOf(maxDepth(root.left), maxDepth(root.right)) + 1
  }
}

class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}
