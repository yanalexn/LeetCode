package com.example.leetcode._Selection_Sort

class SelectionSort {

  /*
  * O(n^2) - time complexity
  * O(1) - space complexity
  * */
  fun sort(arr: IntArray) : IntArray {
    for (i in arr.indices) {
      var tempMinInd = i
      for (j in arr.size - 1 downTo i) {
        if (arr[tempMinInd] > arr[j]) {
          tempMinInd = j
        }
      }
      val temp = arr[tempMinInd]
      arr[tempMinInd] = arr[i]
      arr[i] = temp
    }
    return arr
  }
}
