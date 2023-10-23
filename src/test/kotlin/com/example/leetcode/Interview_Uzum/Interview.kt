package com.example.leetcode.Interview_Uzum

class Interview {

    private val board = Array<IntArray>(8) { IntArray(8) }

    fun eightQueens(): Array<IntArray>  {
//        board[0][0] = 1
//
//        var row = 0
//        var col = 0

        for (i in 0..7) {
            for (j in 0..7) {
                if (canPlace(i, j)) {
                    board[i][j] = 1
                }
            }
        }

        return board
    }

    private fun canPlace(col: Int, row: Int): Boolean {
        for (i in 0..7) {
            if (i != col)
                board[row][i] = 2
            if (i != row)
                board[i][col] = 2
        }
        for (i in 1..7) {
            board[(row + i) % 8][(col + i) % 8]
            board[(row - i) % 8][(col + i) % 8]

        }
    }
}
