package com.example.leetcode._Design_Add_and_Search_Words_Data_Structure

class WordDictionary {

  private data class TrieNode(var isTerminal: Boolean = false) {
    var children: Array<TrieNode?> = Array(26) { null }
  }

  private val root: TrieNode = TrieNode()

  fun addWord(word: String) {
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

  fun search(word: String) = recursivelySearch(word)

  private fun recursivelySearch(word: String, start: Int = 0, node: TrieNode = root): Boolean {
    if (start >= word.length) return node.isTerminal
    return if (word[start] == '.') {
      node.children
        .filterNotNull()
        .map { recursivelySearch(word, start + 1, it) }
        .any { it }
    } else {
      val idx = word[start] - 'a'
      if (node.children[idx] == null) {
        false
      } else {
        recursivelySearch(word, start + 1, node.children[idx]!!)
      }
    }
  }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */
