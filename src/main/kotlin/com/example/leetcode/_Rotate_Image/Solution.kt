package com.example.leetcode._Rotate_Image

class Solution {
  /**
   * From the 1st try!
   *
   * O(n^2)
   *
   * O(1)
   *
   * На будущее, если не вспомнишь: идея в том, чтобы проходится сначала
   * по внешнему квадрату, потом по более внутреннему и т.д. В каждом
   * квадрате пройтись нужно только первой строчке без последнего элемента.
   * Каждый из элементов первой строчки данного квадрата
   * переставляется по циклу из 4 элементов
   */
  fun rotate(matrix: Array<IntArray>): Unit {
    val size = matrix.size
    if (size == 1) return
    for (n in size downTo 2 step 2) {
      for (firstRowButOne in 0..n-2) {
        var row = (size - n) / 2
        var col = row + firstRowButOne
        var temp = matrix[row][col]
        for (cycle in 0..3) {
          var tempRow = row
          row = col
          col = size - 1 - tempRow

          var temp2 = matrix[row][col]
          matrix[row][col] = temp
          temp = temp2
        }
      }
    }
  }
}
