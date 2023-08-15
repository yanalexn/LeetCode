package com.example.leetcode._Two_Sum

class Solution {
  //1, 2, 3;   3
  /**
   * O(n)
   * O(n)
   */
  fun twoSum(nums: IntArray, target: Int): IntArray {
    if (nums.size == 2)
      return intArrayOf(0, 1)

    val intMap = HashMap<Int, MutableList<Int>>()
    for (i in nums.indices) {
      if (!intMap.keys.contains(nums[i]))
        intMap[nums[i]] = mutableListOf(i)
      else
        checkNotNull(intMap[nums[i]]).add(i)
    }
    for (num in intMap.keys) {
      val partner = target - num
      val numIndexList = checkNotNull(intMap[num])
      val numIndex = numIndexList[0]

      if (partner == num && numIndexList.size >= 2)
        return intArrayOf(numIndex, numIndexList[1])

      if (intMap.keys.contains(partner)) {
        val partnerIndexList = checkNotNull(intMap[partner])
        return intArrayOf(numIndex, partnerIndexList[0])
      }
    }
    return intArrayOf()
  }

  /**
   * человек догадался за одну проходку добавлять в HashMap и сверяться с ней
   */
  fun twoSumFaster(nums: IntArray, target: Int): IntArray {

    val ans=IntArray(2)
    val map =HashMap<Int,Int>()

    for(i in nums.indices){

      val sno=target-nums[i]
      if(map.containsKey(sno)){
        ans[0] = map[sno]!!
        ans[1] = i
        break
      }

      map[nums[i]]=i
    }

    println(ans[0]+ans[1])
    return ans
  }
}
