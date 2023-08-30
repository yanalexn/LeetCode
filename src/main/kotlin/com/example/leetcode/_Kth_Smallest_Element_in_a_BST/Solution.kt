package com.example.leetcode._Kth_Smallest_Element_in_a_BST

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
   * Inorder traversal
   *
   * O(n)
   *
   * O(1)
   */
  private var count = 0

  fun kthSmallest(root: TreeNode?, k: Int): Int {
    count = k
    return inorderTraverse(root)!!.`val`
  }

  private fun inorderTraverse(root: TreeNode?): TreeNode? {
    root ?: return null
    val left = inorderTraverse(root?.left)
    left?.let { return it }
    count--
    if (count == 0) return root
    val right = inorderTraverse(root?.right)
    right?.let { return it }
    return null
  }

  /**
   * For some reason the following solution is the fastest one. But it definitely requires too much auxiliary space
   *
   * O(n)
   *
   * O(n)
   */
  var result  = mutableListOf<Int>()
  var k =-1

  fun kthSmallest2(root: TreeNode?, k: Int): Int {
    this.k = k
    traverse(root)
    return result.get(k-1)

  }

  fun traverse(root:TreeNode?){
    if(root == null) return
    traverse(root?.left)
    result.add(root.`val`)
    traverse(root?.right)

  }
}

class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}
