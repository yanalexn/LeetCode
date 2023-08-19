package com.example.leetcode._Single_Number

class Solution {
  /**
   * XOR (exclusive OR):
   * 0 xor 0 = 0
   * 0 xor 1 = 1
   * 1 xor 0 = 1
   * 1 xor 1 = 0
   *
   * And what is also important: AND, OR, XOR operators are commutative so you can easily
   * swap components: a xor b xor c = b xor a xor c
   *
   * O(n)
   * O(1)
   */
  fun singleNumber(nums: IntArray): Int {
    var result = 0
    for (num in nums) {
      result = result xor num
    }
    return result
  }

  /**
   * Is it even possible to use this trick to rewrite Anagram solution in O(n) time and O(1) space?
   *
   * It turns out that this "XOR trick" cannot be used in detecting valid anagrams or palindrome
   * because
   *
   * 1) Valid anagrams' counterexample: "abba" and "xdxd" - these two strings are not anagrams and yet
   * the XOR operator will return 0 because each letters appears even number of times
   *
   * 2) Valid palindrome's counterexample: "abab" - again, not a palindrome but each letter appears twice
   * (even number of times)
   */
  fun isAnagram(first: String, second: String): Boolean {
    var remnant = 0
    for (letter in first) {
      remnant = remnant xor (letter - 'a')
    }
    return remnant == 0
  }
}
