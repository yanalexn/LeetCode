package com.example.leetcode._Gas_Station

class Solution {

  /**
   * This task resembles "Max subarray". It utilizes the same strategy: finding the maximum sum sequence.
   * But instead of finding the maximum sum it finds the beginning of such a subarray.
   *
   * O(n)
   *
   * O(1)
   */
  fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    if (gas.sum() < cost.sum()) return -1
    var start = 0
    var maxSumGas = 0
    var chain = 0
    for (i in gas.indices) {
      val effectiveGas = gas[i] - cost[i]
      val temp = chain + effectiveGas
      chain = if (effectiveGas > temp) {
        start = i
        effectiveGas
      } else
        temp
    }
    val effectiveGas = gas[0] - cost[0]
    val temp = chain + effectiveGas
    chain = if (effectiveGas > temp) {
      start = 0
      effectiveGas
    } else
      temp
    return start
  }
}
