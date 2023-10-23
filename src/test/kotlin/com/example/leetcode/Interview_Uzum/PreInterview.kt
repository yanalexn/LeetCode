package com.example.leetcode.Interview_Uzum

import org.junit.jupiter.api.Test

private const val MODULO = 10000

class PreInterview {
    
    @Test
    fun test() {
        print(sumOfNFibonacciVariationNumbersModulo10000(100))
        //123
    }

    fun sumOfNFibonacciVariationNumbersModulo10000(n: Int): Int {
        var threeStepsBack = 1
        var twoStepsBack = 2
        var oneStepBack = 3
        var current: Int
        var sum = 6
        for (i in 4..n) {
            current = oneStepBack + threeStepsBack
            if (current >= MODULO)
                current %= MODULO

            sum += current
            if (sum >= MODULO)
                sum %= MODULO

            threeStepsBack = twoStepsBack
            twoStepsBack = oneStepBack
            oneStepBack = current
        }
        return sum
    }
}
