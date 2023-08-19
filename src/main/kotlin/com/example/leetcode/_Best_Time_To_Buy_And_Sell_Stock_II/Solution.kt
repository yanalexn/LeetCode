package com.example.leetcode._Best_Time_To_Buy_And_Sell_Stock_II

class Solution {
  /**
   * O(n)
   * O(1)
   */
  fun maxProfit(prices: IntArray): Int {
    if (prices.size == 1) return 0
    var profit = 0
    var bought = Int.MAX_VALUE
    for (i in prices.indices) {
      if (prices[i] > bought) {
        profit += prices[i] - bought
      }
      bought = prices[i]
    }
    return profit
  }
}
