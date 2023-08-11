package com.example.leetcode.calculatePaymentData

import com.example.leetcode.calculateSoldCredit.AbsEventFactory
import com.example.leetcode.calculateSoldCredit.Algorithm
import com.example.leetcode.calculateSoldCredit.CreditCalculations
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.springframework.aot.hint.TypeReference.listOf

@SuppressWarnings("MagicNumber")
class TestProcess {

  companion object {
    @JvmStatic
    fun getData(): List<Arguments> =
        listOf(
            Arguments.of(
                13.0,
                listOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0),
                listOf(listOf(1.0, 2.0, 2.0, 0.0, 0.0), listOf(0.0, 0.0, 1.0, 4.0, 5.0))
            ),
            Arguments.of(
                300000.0,
                listOf(83187.0, 0.0, 70095.0, 0.0, 896000.0, 0.0, 90054.83),
                listOf(listOf(1.0, 2.0, 2.0, 0.0, 0.0), listOf(0.0, 0.0, 1.0, 4.0, 5.0))
            ),
        )
  }

  @ParameterizedTest
  @MethodSource("getData")
  fun test(soldSum: Double, preCreditCalculations: List<Double>, expected: List<List<Double>>) {
    val creditCalculations = CreditCalculations.builder()
        .expiredMainDebt(preCreditCalculations[0])
        .expiredNonCapitalizedDebt(preCreditCalculations[1])
        .expiredPercentDebt(preCreditCalculations[2])
        .percentExpiredDebt(preCreditCalculations[3])
        .mainDebt(preCreditCalculations[4])
        .nonCapitalizedDebt(preCreditCalculations[5])
        .percentDebt(preCreditCalculations[6])
        .build()
    val algorithm = Algorithm()

    println(AbsEventFactory.toCreditStateDto(creditCalculations))
    println(algorithm.process(499, creditCalculations, soldSum))
    println("\n${algorithm.creditTotalDebt()}")
  }
}
