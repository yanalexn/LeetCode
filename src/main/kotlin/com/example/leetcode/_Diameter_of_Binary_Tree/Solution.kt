package com.example.leetcode._Diameter_of_Binary_Tree

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
  fun diameterOfBinaryTree(root: TreeNode?): Int {
    root ?: return 0
    return maxOf(
      depth(root.left) + depth(root.right),
      diameterOfBinaryTree(root.left),
      diameterOfBinaryTree(root.right)
    )
  }

  private fun depth(root: TreeNode?): Int =
    if (root == null) 0
    else 1 + maxOf(depth(root.left), depth(root.right))
}

class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}
