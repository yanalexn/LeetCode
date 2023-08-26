package com.example.leetcode._Symmetric_Tree

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
  fun isSymmetric(root: TreeNode?): Boolean {
    return symmetricallyCompare(root?.left, root?.right)
  }

  private fun symmetricallyCompare(left: TreeNode?, right: TreeNode?): Boolean {
    left ?: right ?: return true
    return left?.`val` == right?.`val`
      && symmetricallyCompare(left?.left, right?.right)
      && symmetricallyCompare(left?.right, right?.left)
  }
}

class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}
