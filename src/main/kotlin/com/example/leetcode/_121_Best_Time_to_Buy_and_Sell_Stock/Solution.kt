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

  /**
   * The DP algorithm
   * O(n)
   * O(1)
   */
  fun maxProfit2(prices: IntArray): Int {
    var profit = 0
    var stock = prices[0]
    for (i in 1 until prices.size) {
      val hypotheticalProfit = prices[i] - stock
      if (profit < hypotheticalProfit) profit = hypotheticalProfit
      if (stock > prices[i]) stock = prices[i]
    }
    return profit
  }
}

