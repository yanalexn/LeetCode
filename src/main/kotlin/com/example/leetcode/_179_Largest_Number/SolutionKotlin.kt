package com.example.leetcode._179_Largest_Number

import java.util.*

class SolutionKotlin {

  /*
  * O(n log n) - time complexity (because of the built-in sort function)
  * O(n) - space complexity
  * */
  inner class LargerNumberComparator : Comparator<String> {
    override fun compare(a: String, b: String): Int {
      val order1 = a + b
      val order2 = b + a
      return order2.compareTo(order1)
    }
  }

  fun largestNumber(nums: IntArray): String {
    // Get input integers as strings.
//    val asStrs = arrayOfNulls<String>(nums.size)
    val asStrs = arrayOfNulls<String>(nums.size)
    for (i in nums.indices) {
      asStrs[i] = nums[i].toString()
    }

    // Sort strings according to custom comparator.
    Arrays.sort(asStrs as Array<String>, LargerNumberComparator())

    // If, after being sorted, the largest number is `0`, the entire number
    // is zero.
    if (asStrs[0] == "0") {
      return "0"
    }

    // Build the largest number from sorted array.
    val stringBuilder = StringBuilder()
    for (numAsStr in asStrs) {
      stringBuilder.append(numAsStr)
    }
    return stringBuilder.toString()
  }
}
