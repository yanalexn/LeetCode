package com.example.leetcode.calculateSoldCredit;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Accessors(chain = true)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class PaymentDistributionLog implements Serializable {

  private static final long serialVersionUID = -2111209047;

  //    private Long id;
//    private Long creditId;
//    private Long creditPaymentId;
//    private LocalDate distributionDate;//should I use it?
  Double principal;
  Double interest;
  //    private Double total;
  Double expiredPrincipal;
  Double expiredInterest;
  Double interestExpiredOnly;
  //    private Double expiredTotal;
//    private Double penalty;
//    private Double restBalance;
  Double nonCapitalizedDebt;
  Double expiredNonCapitalizedDebt;
//    private Double nonRefinancePenalty;
//    private Double expiredNonRefinancePenalty;

//    public PaymentDistributionLog() {
//    }
//
//    public PaymentDistributionLog(PaymentDistributionLog value) {
//        this.id = value.id;
//        this.creditId = value.creditId;
//        this.creditPaymentId = value.creditPaymentId;
//        this.distributionDate = value.distributionDate;
//        this.principal = value.principal;
//        this.interest = value.interest;
//        this.total = value.total;
//        this.expiredPrincipal = value.expiredPrincipal;
//        this.expiredInterest = value.expiredInterest;
//        this.interestExpiredOnly = value.interestExpiredOnly;
//        this.expiredTotal = value.expiredTotal;
//        this.penalty = value.penalty;
//        this.restBalance = value.restBalance;
//        this.nonCapitalizedDebt = value.nonCapitalizedDebt;
//        this.expiredNonCapitalizedDebt = value.expiredNonCapitalizedDebt;
//        this.nonRefinancePenalty = value.nonRefinancePenalty;
//        this.expiredNonRefinancePenalty = value.expiredNonRefinancePenalty;
//    }
//
//    public PaymentDistributionLog(Long id, Long creditId, Long creditPaymentId, LocalDate distributionDate, Double principal, Double interest, Double total, Double expiredPrincipal, Double expiredInterest, Double interestExpiredOnly, Double expiredTotal, Double penalty, Double restBalance, Double nonCapitalizedDebt, Double expiredNonCapitalizedDebt, Double nonRefinancePenalty, Double expiredNonRefinancePenalty) {
//        this.id = id;
//        this.creditId = creditId;
//        this.creditPaymentId = creditPaymentId;
//        this.distributionDate = distributionDate;
//        this.principal = principal;
//        this.interest = interest;
//        this.total = total;
//        this.expiredPrincipal = expiredPrincipal;
//        this.expiredInterest = expiredInterest;
//        this.interestExpiredOnly = interestExpiredOnly;
//        this.expiredTotal = expiredTotal;
//        this.penalty = penalty;
//        this.restBalance = restBalance;
//        this.nonCapitalizedDebt = nonCapitalizedDebt;
//        this.expiredNonCapitalizedDebt = expiredNonCapitalizedDebt;
//        this.nonRefinancePenalty = nonRefinancePenalty;
//        this.expiredNonRefinancePenalty = expiredNonRefinancePenalty;
//    }

  @Override
  public String toString() {
    return "\nPaymentDistributionLog{" +
        "\n     expiredPrincipal=" + expiredPrincipal +
        "\n     expiredNonCapitalizedDebt=" + expiredNonCapitalizedDebt +
        "\n\n     expiredInterest=" + expiredInterest +
        "\n     interestExpiredOnly=" + interestExpiredOnly +
        "\n\n     principal=" + principal +
        "\n     nonCapitalizedDebt=" + nonCapitalizedDebt +
        "\n\n     interest=" + interest +
        "\n}\n";
  }
}

