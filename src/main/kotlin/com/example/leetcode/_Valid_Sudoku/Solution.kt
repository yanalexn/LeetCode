package com.example.leetcode._Valid_Sudoku

class Solution {

  /**
   * O(1) = 3 * 9 * 9 итераций
   *
   * O(1) = 9 элементов
   */
  fun isValidSudoku(board: Array<CharArray>): Boolean {
    for (i in 0 until 9) {
      val map = mutableMapOf<Char, Boolean>()
      for (j in 0 until 9) {
        if ( board[i][j] != '.') {
          if (map[board[i][j]] == null) {
            map[board[i][j]] = true
          } else {
            return false
          }
        }
      }
    }
    for (j in 0 until 9) {
      val map = mutableMapOf<Char, Boolean>()
      for (i in 0 until 9) {
        if ( board[i][j] != '.') {
          if (map[board[i][j]] == null) {
            map[board[i][j]] = true
          } else {
            return false
          }
        }
      }
    }
    for (i in 0 until 9) {
      val map = mutableMapOf<Char, Boolean>()
      for (j in 0 until 9) {
        val cell = board[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3]
        if (cell != '.') {
          if (map[cell] == null) {
            map[cell] = true
          } else {
            return false
          }
        }
      }
    }
    return true
  }
}
