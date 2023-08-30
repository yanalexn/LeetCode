package com.example.leetcode._Count_Good_Nodes_in_Binary_Tree

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

/**
 * Classic DFS
 */
class Solution {

  private var count = 0

  fun goodNodes(root: TreeNode?): Int {
    recursiveCounter(root, root!!.`val`)
    return count
  }

  private fun recursiveCounter(root: TreeNode?, localMax: Int) {
    root ?: return
    if (root.`val` >= localMax) {
      count++
      recursiveCounter(root.left, root.`val`)
      recursiveCounter(root.right, root.`val`)
    } else {
      recursiveCounter(root.left, localMax)
      recursiveCounter(root.right, localMax)
    }
  }
}

class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}
