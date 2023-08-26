package com.example.leetcode._Validate_Binary_Tree_Search

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
  fun isValidBST(root: TreeNode?, min: Int? = null, max: Int? = null): Boolean {
    root ?: return true
    if (min?.let { root.`val` <= it } == true
      || max?.let { root.`val` >= it } == true) return false
    return isValidBST(root.left, min, root.`val`) && isValidBST(root.right, root.`val`, max)
  }
}

class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}
