package com.example.leetcode._My_Atoi

class Solution {
  /**
   * Нули можно было не скипать, а использовать ту же формулу result = 10 * result + (s[k] - '0')
   *
   * sign == -1 && result >= Int.MAX_VALUE.toLong() + 1 если поставить строго больше, то не нужно будет так дотошно
   * париться с +1
   *
   * O(n)
   * O(1)
   */


  //
  //
  //0
  //0001
  //   -012
  //  w^&1234
  //  -01w%$1
  fun myAtoi(s: String): Int {
    if (s.isEmpty() || s.isBlank())
      return 0

    var sign = 1
    var result = 0L
    var i = 0
    while (i in s.indices) {
      if (s[i] == ' ') {
        i++
        continue
      }
      if (s[i] == '-') {
        sign = -1
        i++
      } else if (s[i] == '+') {
        i++
      }
      for (j in i until s.length) {
        if (s[j] == '0')
          continue
        for (k in j until s.length) {
          if (isDigit(s[k])) {//one could use built-in function Char#isDigit() but it's possibly slower than mine
            result = 10 * result + (s[k] - '0')
            if (sign == -1 && result >= Int.MAX_VALUE.toLong() + 1)
              return Int.MIN_VALUE
            else if (sign == 1 && result >= Int.MAX_VALUE)
              return Int.MAX_VALUE
            continue
          } else {
            break
          }
        }
        break
      }
      break
    }
    return sign * result.toInt()
  }

  private fun isDigit(char: Char) =
    char in '0'..'9'
}
