package com.example.leetcode._First_Bad_Version

/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */

class Solution: VersionControl() {
  override fun firstBadVersion(n: Int) : Int {
    var start = 1
    var end = n
    var diff = end - start
    if (diff == 0) return 1
    var middle = 0
    while (diff >= 0) {
      middle = start + diff / 2
      if(isBadVersion(middle)) {
        end = middle - 1
      } else {
        start = middle + 1
      }
      diff = end - start
    }
    return start
  }
}

abstract class VersionControl {
  fun isBadVersion(n: Int): Boolean = TODO()

  abstract fun firstBadVersion(n: Int): Int
}
