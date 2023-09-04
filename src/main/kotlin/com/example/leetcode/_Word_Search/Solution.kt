package com.example.leetcode._Word_Search

class Solution {
  fun exist(board: Array<CharArray>, word: String): Boolean {
    val isVisited = Array<BooleanArray>(board.size) { BooleanArray(board[0].size) }
    for (i in board.indices) {
      for (j in board[i].indices) {
        isVisited[i][j] = true
        if (backtrack(board, word, isVisited, i, j))
          return true
        isVisited[i][j] = false
      }
    }
    return false
  }

  private fun backtrack(
    board: Array<CharArray>,
    word: String,
    isVisited: Array<BooleanArray>,
    row: Int,
    col: Int,
    count: Int = 0
  ): Boolean {
    if (board[row][col] == word[count]) {
      if (count == word.length - 1)
        return true
      if (row + 1 < board.size && !isVisited[row + 1][col]) {
        isVisited[row + 1][col] = true
        if (backtrack(board, word, isVisited, row + 1, col, count + 1))
          return true
        isVisited[row + 1][col] = false
      }
      if (col + 1 < board[0].size && !isVisited[row][col + 1]) {
        isVisited[row][col + 1] = true
        if (backtrack(board, word, isVisited, row, col + 1, count + 1))
          return true
        isVisited[row][col + 1] = false
      }
      if (row - 1 >= 0 && !isVisited[row - 1][col]) {
        isVisited[row - 1][col] = true
        if (backtrack(board, word, isVisited, row - 1, col, count + 1))
          return true
        isVisited[row - 1][col] = false
      }
      if (col - 1 >= 0 && !isVisited[row][col - 1]) {
        isVisited[row][col - 1] = true
        if (backtrack(board, word, isVisited, row, col - 1, count + 1))
          return true
        isVisited[row][col - 1] = false
      }
    }
    return false
  }
}
