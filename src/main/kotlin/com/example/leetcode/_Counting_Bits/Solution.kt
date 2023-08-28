package com.example.leetcode._Counting_Bits

class Solution {

  // 0 -> 0
  // 1 -> 0, 1
  // 2 -> 0, 1, 1
  // 3 -> 0, 1, 1,

  /**
   * Внутри каждого сектора степеней двойки (от 0 до 1, от 2 до 3, от 4 до 7, от 8 до 15 итд)
   * я ссылаюсь на результат всех предыдущих секторов.
   * То есть если мы находимся в секторе 2^n -- 2^(n+1)-1, то по остатку от деления curr % 2^n
   * я узнаю значение в аналогичной позиции в предыдущих секторах и добавляю один.
   *
   * Данная логика намного сложнее топ-решения с LeetCode. Вдобавок ещё и медленнее
   *
   * O(n) - а не O(n log n), как при решении в лоб
   *
   * O(n)
   */
  fun countBits(n: Int): IntArray {
    val result = IntArray(n + 1)
    var curr = 1
    var power = 1
    while (curr <= n) {
      val stop = 1 shl power
      val ref = 1 shl (power - 1)
      while (curr < stop && curr <= n) {
        result[curr] = result[curr % ref] + 1
        curr++
      }
      power++
    }
    return result
  }

  /**
   * Better solution
   *
   * e.g.: 1011 -> (101)1
   * array[(101)1] = array[101] + either 0 or 1 whether the last digit is 1 or not
   *
   */
  fun countBits2(n: Int): IntArray {
    val array = IntArray(n+1)
    for (i in 1..n) array[i] = array[i shr 1] + (i and 1)
    return array
  }
}
