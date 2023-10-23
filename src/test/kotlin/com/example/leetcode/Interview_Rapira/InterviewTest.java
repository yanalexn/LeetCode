package com.example.leetcode.Interview_Rapira;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import org.junit.jupiter.api.Test;

class InterviewTest {

  private record CupEntity(
    BigDecimal price,
    BigDecimal amount
  ) {

  }

  private List<CupEntity> cup = List.of(
    new CupEntity(BigDecimal.valueOf(95.11), BigDecimal.valueOf(10857.77)),
    new CupEntity(BigDecimal.valueOf(94.5), BigDecimal.valueOf(87568)),
    new CupEntity(BigDecimal.valueOf(94.35), BigDecimal.valueOf(87568)),
    new CupEntity(BigDecimal.valueOf(94.32), BigDecimal.valueOf(424.08))
  );

  @Test
  void averageCostTest() {
    BigDecimal initialPayment = BigDecimal.valueOf(1000000000000000L);
    System.out.println(averageCost(initialPayment));
//    assertEquals(averageCost(initialPayment), BigDecimal.valueOf(95.42));
  }

  private BigDecimal averageCost(BigDecimal initialPayment) {
    BigDecimal payment = BigDecimal.ZERO.add(initialPayment);
    BigDecimal afterExchange = BigDecimal.ZERO;
    MathContext mc = new MathContext(10, RoundingMode.HALF_UP);

    int cupCounter = cup.size() - 1;
    while (!payment.equals(BigDecimal.ZERO) && cupCounter >= 0) {
      BigDecimal targetCurrencyAmount = cup.get(cupCounter).amount;
      BigDecimal price = cup.get(cupCounter).price;
      BigDecimal originalCurrencyAmount = targetCurrencyAmount.multiply(price);

      if (payment.compareTo(originalCurrencyAmount) >= 0) {
        afterExchange = afterExchange.add(targetCurrencyAmount);
        payment = payment.subtract(originalCurrencyAmount);
      } else {
        afterExchange = afterExchange.add(payment.divide(price, mc));
        payment = BigDecimal.ZERO;
        break;
      }

      cupCounter--;
    }

    if (cupCounter < 0 && payment.compareTo(BigDecimal.ZERO) > 0) {
      throw new IllegalArgumentException("Can't convert that much");
    }

    return initialPayment.divide(afterExchange, mc)
      .setScale(2, RoundingMode.HALF_DOWN);
  }
}
