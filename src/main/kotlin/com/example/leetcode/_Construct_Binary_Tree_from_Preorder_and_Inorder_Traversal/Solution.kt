package com.example.leetcode._Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal

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
 * O(n)
 *
 * O(n)
 */
class Solution {

  private var startPreorder: Int = 0
  private lateinit var preorder: IntArray
  private lateinit var inorder: IntArray

  fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    this.preorder = preorder
    this.inorder = inorder
    return buildTree()
  }

  private fun buildTree(startInorder: Int = 0, endInorder: Int = inorder.size): TreeNode? {
    if (startPreorder >= preorder.size) return null
    if (endInorder <= startInorder) return null

    val value = preorder[startPreorder]
    startPreorder++
    val root = TreeNode(value)
    val middle = inorder.indexOf(value)
    root.left = buildTree(startInorder, middle)
    root.right = buildTree(middle + 1, endInorder)

    return root
  }
}

class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}
