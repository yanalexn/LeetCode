package com.example.leetcode._121_Best_Time_to_Buy_and_Sell_Stock

class Solution {
  fun maxProfit(prices: IntArray): Int {
    val size = prices.size
    if (size == 1 || size == 0) {
      return 0
    }
    val minIndex = prices.withIndex().minBy { it.value }.index
    val max = prices.copyOfRange(minIndex, size).max()
    return maxOf(max - prices[minIndex], maxProfit(prices.copyOfRange(0, minIndex)))
  }
}

