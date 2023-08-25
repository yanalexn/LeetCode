package com.example.leetcode._Reverse_Linked_List

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SolutionTest {

  companion object {
    @JvmStatic
    fun data(): List<Arguments> =
      listOf(
        Arguments.of(null, null),
        Arguments.of(
          ListNode(1),
          ListNode(1)
        ),
        Arguments.of(
          ListNode(1).apply { next = ListNode(2) },
          ListNode(2).apply { next = ListNode(1) }
        ),
        Arguments.of(
          ListNode(1)
            .apply {
              next = ListNode(2)
                .apply { next = ListNode(3) }
            },
          ListNode(3)
            .apply {
              next = ListNode(2)
                .apply { next = ListNode(1) }
            }
        ),
      )
  }

  private val solution = Solution()

  @ParameterizedTest
  @MethodSource("data")
  fun `test algorithm`(input: ListNode?, expected: ListNode?) {
    var temp = solution.reverseList(input)
    var tempExp = expected
    do {
      assertEquals(temp?.`val`, tempExp?.`val`)
      temp = temp?.next
      tempExp = tempExp?.next
    } while (temp != null && tempExp != null)
  }
}
