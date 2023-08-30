package com.example.leetcode._Balanced_Binary_Tree

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
   * Slow solution:(
   *
   * O(n^2)
   *
   * O(1)
   */
  fun isBalanced(root: TreeNode?): Boolean {
    root ?: return true
    return (height(root.left) == height(root.right)
      || height(root.left) == 1 + height(root.right)
      || 1 + height(root.left) == height(root.right))
      && isBalanced(root.left)
      && isBalanced(root.right)
  }

  private fun height(root: TreeNode?): Int {
    root ?: return 0
    return 1 + maxOf(height(root.left), height(root.right))
  }

  /**
   * O(n)!
   *
   * O(1)
   */
  var isBalanced = true
  fun isBalanced2(root: TreeNode?): Boolean {
    dfs(root)
    return isBalanced
  }
  fun dfs(root: TreeNode?): Int {
    if (isBalanced.not() || root == null) return 0
    val left = dfs(root.left)
    val right = dfs(root.right)
    if (Math.abs(left - right) > 1) {
      isBalanced = false
      return 0
    }
    return 1 + maxOf(left, right)
  }
}

class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}
