//package com.example.leetcode.calculateSoldCredit;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.List;
//
//import static com.example.leetcode.calculateSoldCredit.CreditPaymentSource.COLLECTOR;
//import static com.example.leetcode.calculateSoldCredit.Currency.KZT;
//
//public class CalculatePaymentData {
//
////    private BigDecimal soldSum;
////    private BigDecimal expiredMainDebt;
////    private BigDecimal expiredNonCapitalizedDebt;
//
//    private double soldSum;
//    private double expiredMainDebt;
//    private double expiredNonCapitalizedDebt;
////    private double expiredPercentDebt;
////    private double percentExpiredDebt;
////    private double mainDebt;
////    private double nonCapitalizedDebt;
////    private double percentDebt;
//
//
//    public CalculatePaymentData(double soldSum, CreditCalculations creditCalculations) {
////        this.soldSum = BigDecimal.valueOf(soldSum);
////        this.expiredMainDebt = BigDecimal.valueOf(creditCalculations.getExpiredMainDebt());
////        this.expiredNonCapitalizedDebt = BigDecimal.valueOf(creditCalculations.getExpiredNonCapitalizedDebt());
//
//        this.soldSum = soldSum;
//        this.expiredMainDebt = creditCalculations.getExpiredMainDebt();
//        this.expiredNonCapitalizedDebt = creditCalculations.getExpiredNonCapitalizedDebt();
////        this.expiredPercentDebt = creditCalculations.getExpiredPercentDebt();
////        this.percentExpiredDebt = creditCalculations.getPercentExpiredDebt();
////        this.mainDebt = creditCalculations.getMainDebt();
////        this.nonCapitalizedDebt = creditCalculations.getNonCapitalizedDebt();
////        this.percentDebt = creditCalculations.getPercentDebt();
//    }
//
//
//    public PaymentData calculate(long creditId) {
//        return new PaymentData(
//                calculateDistribution(),
//                creditId,
//                1L,//TODO: what to do with creditPaymentId?
//                COLLECTOR,
//                LocalDate.now(),
//                KZT,
////                soldSum.doubleValue(),
//                soldSum
//        );
//    }
//
//    private List<PaymentDistributionLog> calculateDistribution() {
////        Double collectorsExpiredPrinciple = compareAndCalculate(expiredMainDebt);
////        Double collectorsExpiredNonCapitalizedDebt = compareAndCalculate(expiredNonCapitalizedDebt);
////        Double collectorsExpiredInterest = compareAndCalculate(expiredPercentDebt);
////        Double collectorsInterestExpiredOnly = compareAndCalculate(percentExpiredDebt);
////        Double collectorsPrincipal = 0.;
////        Double collectorsNonCapitalizedDebt = 0.;
////        Double collectorsInterest = 0.;
//
//        Double collectorsExpiredPrinciple;
//        Double collectorsExpiredNonCapitalizedDebt;
////        Double collectorsExpiredInterest = compareAndCalculate(expiredPercentDebt);
////        Double collectorsInterestExpiredOnly = compareAndCalculate(percentExpiredDebt);
////        Double collectorsPrincipal = 0.;
////        Double collectorsNonCapitalizedDebt = 0.;
////        Double collectorsInterest = 0.;
//
//        if (soldSum >= expiredMainDebt) {
//            collectorsExpiredPrinciple = expiredMainDebt;
//            soldSum -= expiredMainDebt;
//            expiredMainDebt = 0.;
//        } else {
//            collectorsExpiredPrinciple = soldSum;
//            soldSum = 0.;
//            expiredMainDebt -= soldSum;
//        }
//
//        return List.of(
//                new PaymentDistributionLog()
//                        .setExpiredPrincipal(collectorsExpiredPrinciple)
////                        .setExpiredNonCapitalizedDebt(collectorsExpiredNonCapitalizedDebt)
////                        .setExpiredInterest(collectorsExpiredInterest)
////                        .setInterestExpiredOnly(collectorsInterestExpiredOnly)
////                        .setPrincipal(collectorsPrincipal)
////                        .setNonCapitalizedDebt(collectorsNonCapitalizedDebt)
////                        .setInterest(collectorsInterest)
//        );
//    }
//
////    private double compareAndCalculate(BigDecimal sum) {
////        BigDecimal result;
////        if (soldSum.compareTo(sum) >= 0) {
////            result = sum;
////            soldSum = soldSum.subtract(sum);
////            sum = BigDecimal.ZERO;
////        } else {
////            result = soldSum;
////            soldSum = 0.;
////            this.expiredMainDebt = sum - soldSum;
////        }
////        return result;
////    }
//}
