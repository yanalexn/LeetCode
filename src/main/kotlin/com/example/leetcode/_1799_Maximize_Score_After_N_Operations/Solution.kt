package com.example.leetcode._1799_Maximize_Score_After_N_Operations

class Solution {
    private var numLength = 0
    private var numberOfOperations = 0
    private lateinit var gcdMatrix: Array<IntArray>
    private val finalGcds = mutableListOf<Int>()

    //        private lateinit var bannedIndexes: IntArray
    private val bannedIndexes = mutableListOf<Int>()

    fun maxScore(nums: IntArray): Int {
        numLength = nums.size
        numberOfOperations = numLength / 2
        gcdMatrix = Array(numLength) { IntArray(numLength) }
//        bannedIndexes = IntArray(numLength) {-1}
        var max = 1
        var tempRow = -1
        var tempColumn = -1

        for (column in 1 until numLength) {
            for (row in 0 until column) {
                val temp = gcd(nums[row], nums[column])
                gcdMatrix[row][column] = temp
                if (temp > max) {
                    max = temp
//                    bannedIndexes[0] = row
//                    bannedIndexes[1] = column
//                    bannedIndexes.removeLastOrNull()
//                    bannedIndexes.removeLastOrNull()
//                    bannedIndexes.add(row)
//                    bannedIndexes.add(column)
                    tempRow = row
                    tempColumn = column
                }
            }
        }
        bannedIndexes.add(tempRow)
        bannedIndexes.add(tempColumn)
        finalGcds.add(max)
        findMaxAndBanIndex()

        return computeSum()

    }

    private fun gcd(a: Int, b: Int): Int {
        if (b == 0) return a
        return gcd(b, a % b)
    }

    private fun findMaxAndBanIndex() {
        while (finalGcds.size != numberOfOperations) {
            var max = 1
            val finalGcgsCounter = finalGcds.size * 2
            var tempRow = -1
            var tempColumn = -1

            for (column in 1 until numLength) {
                if (bannedIndexes.contains(column))
                    continue

                for (row in 0 until column) {
                    if (bannedIndexes.contains(row))
                        continue

                    val temp = gcdMatrix[row][column]
                    if (temp > max) {
                        max = temp
//                        bannedIndexes[finalGcgsCuonter] = row
//                        bannedIndexes[finalGcgsCuonter + 1] = column
//                        bannedIndexes.removeLastOrNull()
//                        bannedIndexes.removeLastOrNull()
//                        bannedIndexes.add(row)
//                        bannedIndexes.add(column)
                        tempRow = row
                        tempColumn = column
                    }
                }
            }
            bannedIndexes.add(tempRow)
            bannedIndexes.add(tempColumn)
            finalGcds.add(max)
        }
    }

    private fun computeSum(): Int {
        var sum = 0;
        for (counter in 0 until finalGcds.size) {
            sum += finalGcds[counter] * (numberOfOperations - counter)
        }

        return sum
    }
}
