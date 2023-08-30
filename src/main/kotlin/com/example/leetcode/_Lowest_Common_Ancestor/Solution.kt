package com.example.leetcode._Lowest_Common_Ancestor

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
  fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if ((p!!.`val` <= root!!.`val` && root!!.`val` <= q!!.`val`)
      ||(q!!.`val` <= root!!.`val` && root!!.`val` <= p!!.`val`))
      return root
    else if (p!!.`val` <= root!!.`val`)
      return lowestCommonAncestor(root.left, p, q)
    else
      return lowestCommonAncestor(root.right, p, q)
  }
}

class TreeNode(var `val`: Int = 0) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}
