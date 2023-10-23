package com.example.leetcode._Binary_Tree_Level_Order_Traversal

import java.util.*
import kotlin.collections.ArrayList

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

  private data class TreeNodeWrapper(
    val treeNode: TreeNode,
    val lvl: Int = 1
  )

  /**
   * O(n)
   *
   * O(n)
   */
  fun levelOrder(root: TreeNode?): List<List<Int>> {
    val result = mutableListOf(mutableListOf<Int>())
    val queue = ArrayDeque<TreeNodeWrapper>()

    root?.let { queue.add(TreeNodeWrapper(it, 0)) }
    var temp = queue.poll()
    while (temp != null) {

      with(temp) {
        if (result.size < this.lvl + 1) {
          result.add(mutableListOf())
        }
        result[this.lvl].add(temp.treeNode.`val`)
        this.treeNode.left?.let { queue.add(TreeNodeWrapper(it, this.lvl + 1)) }
        this.treeNode.right?.let { queue.add(TreeNodeWrapper(it, this.lvl + 1)) }
      }
      temp = queue.poll()
    }

    return result
  }

  /**
   * Slightly better solution (doesn't require additional space for each Node's lvl)
   */
  fun levelOrder2(root: TreeNode?): List<List<Int>> {
    var output : MutableList<List<Int>> = ArrayList()
    if (root == null) return output
    var queue = LinkedList<TreeNode>()
    queue.add(root)
    while (queue.isNotEmpty()) {
      var size = queue.size
      var curLevel : MutableList<Int> = ArrayList()
      for (i in 0 until size) {
        var currNode = queue.pop()
        curLevel.add(currNode.`val`)
        if (currNode.`left` != null) queue.add(currNode.`left`!!)
        if (currNode.`right` != null) queue.add(currNode.`right`!!)
      }
      output.add(curLevel)
    }
    return output
  }
}

class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}


