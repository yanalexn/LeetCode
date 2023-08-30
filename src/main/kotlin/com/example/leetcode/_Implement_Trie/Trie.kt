package com.example.leetcode._Implement_Trie

class Trie {

  /**
   * Another idea was to use a hash map instead of an array, buy still this solution is pretty fast and doesn't require
   * too much auxiliary space compared to other solutions
   *
   * O(n) - beats 94%
   *
   * O(?) - depends on how many calls were before (best case - O(1), worst - O(n)) - beats 78%
   */
  private data class TrieNode(var isTerminal: Boolean = false) {
    var children: Array<TrieNode?> = Array(26) { null }
  }

  private val root: TrieNode = TrieNode()

  fun insert(word: String) {
    var node = root
    for (letter in word) {
      val idx = letter - 'a'
      if (node.children[idx] == null) {
        node.children[idx] = TrieNode()
      }
      node = node.children[idx]!!
    }
    node.isTerminal = true
  }

  fun search(word: String): Boolean {
    var node = root
    for (letter in word) {
      val idx = letter - 'a'
      if (node.children[idx] == null) {
        return false
      }
      node = node.children[idx]!!
    }
    return node.isTerminal
  }

  fun startsWith(prefix: String): Boolean {
    var node = root
    for (letter in prefix) {
      val idx = letter - 'a'
      if (node.children[idx] == null) {
        return false
      }
      node = node.children[idx]!!
    }
    return true
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
