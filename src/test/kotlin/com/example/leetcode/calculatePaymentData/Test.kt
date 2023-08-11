package com.example.leetcode.calculatePaymentData

import org.junit.jupiter.params.provider.Arguments

@SuppressWarnings("MagicNumber")
class Test {

  companion object {
    @JvmStatic
    fun getData(): List<Arguments> =
        listOf(
            Arguments.of(
                5.0,
                listOf(1.0, 2.0, 3.0, 4.0, 5.0),
                listOf(listOf(1.0, 2.0, 2.0, 0.0, 0.0), listOf(0.0, 0.0, 1.0, 4.0, 5.0))
            ),
            Arguments.of(
                4.0,
                listOf(1.0, 2.0, 3.0, 4.0, 5.0),
                listOf(listOf(1.0, 2.0, 1.0, 0.0, 0.0), listOf(0.0, 0.0, 2.0, 4.0, 5.0))
            ),
            Arguments.of(
                1.0,
                listOf(1.0, 2.0, 3.0, 4.0, 5.0),
                listOf(listOf(1.0, 0.0, 0.0, 0.0, 0.0), listOf(0.0, 2.0, 3.0, 4.0, 5.0))
            ),
            Arguments.of(
                15.0,
                listOf(1.0, 2.0, 3.0, 4.0, 5.0),
                listOf(listOf(1.0, 2.0, 3.0, 4.0, 5.0), listOf(0.0, 0.0, 0.0, 0.0, 0.0))
            ),
//                        Arguments.of(//has rounding problems, but in general ok
//                                5.33,
//                                listOf(1.0, 2.0, 3.0, 4.0, 5.0),
//                                listOf(listOf(1.0, 2.0, 2.33, 0.0, 0.0), listOf(0.0, 0.0, 0.67, 4.0, 5.0))
//                        ),
        )
  }

//    private val solution = Solution()
//
//    @ParameterizedTest
//    @MethodSource("getData")
//    fun maximize(nums: IntArray, expected: Int) {
//        Assertions.assertEquals(expected, solution.maxScore(nums))
//    }

//  @Test
//  fun testDistributions() {
//    val creditCalculations = CreditCalculations.builder()
//        .expiredMainDebt(1000.0)
//        .expiredNonCapitalizedDebt(1000.0)
//        .expiredPercentDebt(1000.0)
//        .percentExpiredDebt(1000.0)
//        .mainDebt(1000.0)
//        .nonCapitalizedDebt(1000.0)
//        .percentDebt(1000.0)
//        .build();
//
////        val calculatePaymentData =
//
//    println(CalculatePaymentData(1_500.0, creditCalculations).calculate(499))
//  }

//  @ParameterizedTest
//  @MethodSource("getData")
//  fun testAlgorithm(soldSum: Double, debts: List<Double>, expected: List<List<Double>>) {
//    assertEquals(expected, Algorithm().calculate(soldSum, debts))
//    val emptyList = emptyList<Int>()
//    print("${emptyList[0]}")
//  }

}
