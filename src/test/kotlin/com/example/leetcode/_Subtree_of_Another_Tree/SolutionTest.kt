package com.example.leetcode._Subtree_of_Another_Tree

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

class SolutionTest {

  companion object {
    @JvmStatic
    fun data(): List<Arguments> =
      listOf(
        Arguments.of(
          constructTree(listOf(5, 2, null)),
          constructTree(listOf(2)),
          true
        ),
        Arguments.of(
          constructTree(listOf(3, 4, 5, 1, 2, null, null)),
          constructTree(listOf(4, 1, 2)),
          true
        ),
        Arguments.of(
          constructTree(listOf(3, 4, 5, 1, 2, null, null, null, null, 0, null)),
          constructTree(listOf(4, 1, 2)),
          false
        ),
        Arguments.of(
          constructTree(
            listOf(29, 28, 30, 27, 29, 29, 31, 26, 26, 28, 28, 28, 28, 30, 32, 25, 25, 25, 25, 27, 29, null, 29, 29, 29,
              null, 29,
              29, 29, 31, null, 26, 24, 26, 26, 26, null, 24, null, null, 26, 28, null, 28, 28, 30, 28, 30, 30, null,
              null, 30, 30, 30, 30, null, 32, 27, 27, null, 25, 25, null, null, 25, 27, 27, null, null, null, null, 27,
              27, 27, 29, null, null, null, 31, 29, null, 31, null, 29, 29, null, null, 29, 31, null, 29, 29, 31, null,
              31, null, null, null, 28, 24, 24, 24, 26, 24, 24, null, 28, 26, 28, 26, null, null, null, 28, 28, null,
              28, null, null, 28, 30, 32, null, 30, 28, 28, 28, null, null, null, null, 28, 30, 28, 28, null, null,
              null, null, 27, null, null, null, 23, 25, null, null, null, null, null, null, null, null, 27, 27, null,
              null, null, 29, null, null, null, null, 27, 29, null, 27, 27, null, null, null, null, 31, 29, 29, 27, 29,
              null, 29, 27, 29, null, null, null, null, 27, null, null, 29, null, null, 22, 22, null, 26, null, null,
              26, 28, 28, 28, null, 28, null, 28, null, 28, null, null, null, null, null, null, null, 28, null, 28, 28,
              null, 30, null, null, null, null, null, 26, null, 28, 30, 21, 23, null, null, null, 25, null, 27, null,
              null, null, null, 27, 29, 27, 29, 27, 27, null, null, null, null, 29, null, 27, null, null, null, 25, 27,
              null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 28,
              null, null, null, null, null, null, null, null, 26, null, null, 24, null, 28, null, null, null, null,
              null, 23)),
          constructTree(listOf(29)),
          true
        ),
      )

    @JvmStatic
    fun `test for test`(): List<Arguments> =
      listOf(
        Arguments.of(constructTree(listOf<Int?>(null))),
        Arguments.of(constructTree(listOf<Int?>(5, 2, 1))),
        Arguments.of(constructTree(listOf<Int?>(5, 2, 1, 3, null, null, 4))),
      )

    fun constructTree(input: List<Int?>): TreeNode? {
      val nodes = LinkedList<Int?>()
      nodes.addAll(input)

      val first = nodes.poll() ?: return null

      val root = TreeNode(first)
      println(first)

      val treeQueue = LinkedList<TreeNode>()
      treeQueue.add(root)

      while (nodes.isNotEmpty()) {
        val qSize = treeQueue.size
        repeat(qSize) {
          val curr = treeQueue.poll()

          nodes.poll()?.let {
            curr.left = TreeNode(it)
            print("$it ")
          } ?: print("n ")
          nodes.poll()?.let {
            curr.right = TreeNode(it)
            print("$it ")
          } ?: print("n ")

          curr.left?.let { treeQueue.add(it) }
          curr.right?.let { treeQueue.add(it) }
        }
        println()
      }
      println("__________________________________________________________________________________________")
      return root
    }
  }

  private val solution = Solution()

  @ParameterizedTest
  @MethodSource("data")
  fun `test algorithm`(root: TreeNode?, subRoot: TreeNode?, expected: Boolean) {
    Assertions.assertEquals(expected, solution.isSubtree(root, subRoot))
  }

  @ParameterizedTest
  @MethodSource("test for test")
  fun `constructing trees`(root: TreeNode?) {
    println(root)
  }
}
