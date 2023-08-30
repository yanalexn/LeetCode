package com.example.leetcode._Same_Tree

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
  fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if ((p == null) xor (q == null)) return false
    else if (p == null && q == null) return true
    return p!!.`val` == q!!.`val`
      && isSameTree(p?.left, q?.left)
      && isSameTree(p?.right, q?.right)
  }

  /**
   * Same time and space complexity but improved: the algorithm aborts if
   * node values are not the same
   */
  fun isSameTree2(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) return true
    if (p == null || q == null) return false

    if (p.`val` == q.`val`) {
      val leftSame = isSameTree(p.left, q.left)
      val rightSame = isSameTree(p.right, q.right)
      return leftSame && rightSame
    } else {
      return false
    }
  }
}

class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}
