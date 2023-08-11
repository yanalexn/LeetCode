package com.example.leetcode.calculateSoldCredit

import java.time.LocalDate
import java.time.OffsetDateTime

//data class PaymentData(
//        val paymentDistribution: List<PaymentDistributionLog>,
//        var creditId: Long,
//        val creditPaymentId: Long,
//        val paymentSource: CreditPaymentSource,
//        val paymentDate: LocalDate,
//        val currency: Currency,
//        val paymentAmount: Double
//)

data class PaymentData(
    var creditId: Long,
    val creditPaymentId: Long?,
    val paymentSource: CreditPaymentSource,
    val paymentDate: LocalDate,
    val currency: Currency,
    val paymentAmount: Double,
    val paymentDistribution: List<PaymentDistributionLog>
)

data class PaymentEvent(
    val solvaPaymentId: Long? = null,
    val targetId: Long,
    val absTargetId: Long? = null,
    val baseAmount: Double? = null,
    val currency: Currency = Currency.KZT,
    val paymentSource: CreditPaymentSource,
    val distributions: List<Distribution>,
    val distributionDate: LocalDate,
    val bankAccountDetails: BankAccountDetails? = null,
    val eventTime: OffsetDateTime,
    val ignoreAbsSending: Boolean = false
){
  override fun toString(): String {
    return "\nPaymentEvent(" +
        "\n   solvaPaymentId=$solvaPaymentId, " +
        "\n   targetId=$targetId, " +
        "\n   absTargetId=$absTargetId, " +
        "\n   baseAmount=$baseAmount, " +
        "\n   currency=$currency, " +
        "\n   paymentSource=$paymentSource, " +
        "\n   distributions=$distributions, " +
        "\n   distributionDate=$distributionDate, " +
        "\n   bankAccountDetails=$bankAccountDetails, " +
        "\n   eventTime=$eventTime, " +
        "\n   ignoreAbsSending=$ignoreAbsSending" +
        "\n)"
  }
}

data class BankAccountDetails(
    val accountRecipient: String,
    val bicBankRecipient: String,
)

data class Distribution(
    val type: DistributionType,
    val value: Double,
)

data class PaymentsEvent(
    val paymentEventList: List<PaymentEvent>,
    val changeStatus: ChangeStatus? = null
){
  override fun toString(): String {
    return "PaymentsEvent(" +
        "\n   paymentEventList=$paymentEventList, " +
        "\n   changeStatus=$changeStatus" +
        "\n)"
  }
}


enum class ChangeStatus {
  COMPLETED,
  RETURN
}
enum class DistributionType {
  DEBT,
  REWARD,
  PENALTY,
  FINE,
  EXPIRED_REWARD,
  EXPIRED_MAIN_DEBT,
  EXPIRED_MAIN_REWARD
}

const val SCALE = 5
const val MIN_BORDER_VALUE = 0.01
const val OLD_PRODUCT_INSTALLMENT_LOAN_LEGACY = "INSTALLMENT_LOAN_LEGACY"


data class CreditStateDto(
    val balanceExpiredDebt: Double,
    val balanceExpiredReward: Double,
    val balanceDebt: Double,
    val balanceReward: Double,
//    val balanceOverpay: Double,
//    val distributedPayments: List<PaymentDto>
){
  override fun toString(): String {
    return "CreditStateDto(" +
        "\n   balanceExpiredDebt=$balanceExpiredDebt, " +
        "\n   balanceExpiredReward=$balanceExpiredReward, " +
        "\n   balanceDebt=$balanceDebt, " +
        "\n   balanceReward=$balanceReward" +
        "\n)\n"
  }
}
