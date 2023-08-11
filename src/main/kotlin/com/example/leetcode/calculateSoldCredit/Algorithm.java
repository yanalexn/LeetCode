package com.example.leetcode.calculateSoldCredit;

import static com.example.leetcode.calculateSoldCredit.CreditPaymentSource.BONUS;
import static com.example.leetcode.calculateSoldCredit.CreditPaymentSource.COLLECTOR;
import static com.example.leetcode.calculateSoldCredit.Currency.KZT;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Algorithm {
//    public List<List<Double>> calculate(double soldSum, List<Double> debts) {
//        List<Double> firstList = new ArrayList<>(5);
//        List<Double> secondList = new ArrayList<>(5);
//
//        for (Double debt : debts) {
//            if (soldSum >= debt) {
//                firstList.add(debt);
//                secondList.add(0.);
//                soldSum -= debt;
//            } else {
//                firstList.add(soldSum);
//                secondList.add(debt - soldSum);
//                soldSum = 0.;
//            }
//        }
//
//        return List.of(firstList, secondList);
//    }

  private Long creditId;
  private CreditCalculations creditCalculations;
  private LocalDate dateSold;
  private Double soldSum;

  public PaymentsEvent process(Long creditId, CreditCalculations creditCalculations, double soldSum) {
    fetchAllParameters(creditId, creditCalculations, soldSum);
    return sendMultiplePaymentsToAbs(
        calculateCollectorAndBonusPaymentData()
    );
  }

  private void fetchAllParameters(Long creditId, CreditCalculations creditCalculations, double soldSum) {
    this.creditId = creditId;
    this.creditCalculations = creditCalculations;
    this.dateSold = LocalDate.now();
    this.soldSum = soldSum;
  }

  private List<PaymentData> calculateCollectorAndBonusPaymentData() {
    List<PaymentDistributionLog> collectorAndBonusDistributions = calculateCollectorAndBonusDistributions();
    PaymentData collectorPaymentData = newPaymentData(COLLECTOR, soldSum, collectorAndBonusDistributions.get(0));
    PaymentData bonusPaymentData = newPaymentData(BONUS, creditTotalDebt() - soldSum, collectorAndBonusDistributions.get(1));
    return List.of(collectorPaymentData, bonusPaymentData);
  }

  private List<PaymentDistributionLog> calculateCollectorAndBonusDistributions() {
    List<Double> debts = List.of(
        creditCalculations.getExpiredMainDebt(),
        creditCalculations.getExpiredNonCapitalizedDebt(),
        creditCalculations.getExpiredPercentDebt(),
        creditCalculations.getPercentExpiredDebt(),
        creditCalculations.getMainDebt() - creditCalculations.getExpiredMainDebt(),
        creditCalculations.getNonCapitalizedDebt() - creditCalculations.getExpiredNonCapitalizedDebt(),
        creditCalculations.getPercentDebt() - creditCalculations.getExpiredPercentDebt()
    );
    List<Double> collectorDistribution = new ArrayList<>();
    List<Double> bonusDistribution = new ArrayList<>();
    double soldSumResidual = this.soldSum;

    for (double debt : debts) {
      if (soldSumResidual >= debt) {
        collectorDistribution.add(debt);
        bonusDistribution.add(0.);
        soldSumResidual -= debt;
      } else {
        collectorDistribution.add(soldSumResidual);
        bonusDistribution.add(debt - soldSumResidual);
        soldSumResidual = 0.;
      }
    }

    return List.of(
        new PaymentDistributionLog()
            .setExpiredPrincipal(collectorDistribution.get(0))
            .setExpiredNonCapitalizedDebt(collectorDistribution.get(1))
            .setExpiredInterest(collectorDistribution.get(2))
            .setInterestExpiredOnly(collectorDistribution.get(3))
            .setPrincipal(collectorDistribution.get(4) + collectorDistribution.get(0))
            .setNonCapitalizedDebt(collectorDistribution.get(5) + collectorDistribution.get(1))
            .setInterest(collectorDistribution.get(6) + collectorDistribution.get(2)),
        new PaymentDistributionLog()
            .setExpiredPrincipal(bonusDistribution.get(0))
            .setExpiredNonCapitalizedDebt(bonusDistribution.get(1))
            .setExpiredInterest(bonusDistribution.get(2))
            .setInterestExpiredOnly(bonusDistribution.get(3))
            .setPrincipal(bonusDistribution.get(4) + bonusDistribution.get(0))
            .setNonCapitalizedDebt(bonusDistribution.get(5) + bonusDistribution.get(1))
            .setInterest(bonusDistribution.get(6) + bonusDistribution.get(2))
    );
  }

  private PaymentData newPaymentData(
      CreditPaymentSource creditPaymentSource,
      double paymentAmount,
      PaymentDistributionLog paymentDistributionLog
  ) {
    return new PaymentData(
        creditId,
        null,
        creditPaymentSource,
        dateSold,
        KZT,
        paymentAmount,
        Collections.singletonList(paymentDistributionLog)
    );
  }

  public double creditTotalDebt() {
    return creditCalculations.getPercentExpiredDebt()
        + creditCalculations.getMainDebt()
        + creditCalculations.getNonCapitalizedDebt()
        + creditCalculations.getPercentDebt();
  }

  public PaymentsEvent sendMultiplePaymentsToAbs(List<PaymentData> paymentData) {
    return AbsEventFactory.INSTANCE.newPaymentEvent(ChangeStatus.COMPLETED, paymentData);
  }
}
