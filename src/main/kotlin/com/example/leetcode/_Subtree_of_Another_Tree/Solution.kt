package com.example.leetcode._Subtree_of_Another_Tree

/*
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
   * O(n^2)
   *
   * O(1)
   */
  fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
    root ?: return false
    return isSameTree(root, subRoot)
      || isSubtree(root.left, subRoot)
      || isSubtree(root.right, subRoot)
  }

  private fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) return true
    if (p == null || q == null) return false

    return p.`val` == q.`val`
      && isSameTree(p.left, q.left)
      && isSameTree(p.right, q.right)
  }
}

class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}
