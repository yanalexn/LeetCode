package com.example.leetcode._Reverse_Integer

class FastestSolution {

  /**
   * Не пишет кастомный метод pow() - вместо это каждый раз результат умножает на 10
   * Делает только 1 проходку, а не 2
   * Сразу внутри первой проходки проверяет на превышение MIN/MAX_VALUE
   */
  fun reverse(x: Int): Int {
    var tX = x
    var result = 0L
    var intResult = 0
    while (tX != 0) {
      val lastDigit = tX % 10
      result = (result * 10) + lastDigit
      tX /= 10
      if (result > Integer.MAX_VALUE || result < (Integer.MIN_VALUE))
        return 0
      intResult = (intResult * 10) + lastDigit
    }
    return intResult
  }
}
