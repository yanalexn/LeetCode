package com.example.leetcode._Binary_Tree_Right_Side_View

import java.util.*
import kotlin.collections.ArrayList

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
  fun rightSideView(root: TreeNode?): List<Int> {
    root ?: return listOf<Int>()
    val result = mutableListOf<Int>()
    val q = LinkedList<TreeNode>()
    q.add(root)
    while (q.isNotEmpty()) {
      val size = q.size
      var temp = root!!
      repeat(size) {
        temp = q.poll()
        temp.left?.let { q.add(it) }
        temp.right?.let { q.add(it) }
      }
      result.add(temp.`val`)
    }
    return result
  }

  /**
   * Another lovely solution
   */
  fun rightSideView2(root: TreeNode?): List<Int> {
    val res = ArrayList<Int>()
    help(root, 0, res)
    return res
  }

  fun help(root: TreeNode?, level: Int, res: ArrayList<Int>) {
    if (root == null) {
      return
    }
    if (level == res.size) {
      res.add(root.`val`)
    }
    help(root.right, level + 1, res)
    help(root.left, level + 1, res)
  }
}

class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}
