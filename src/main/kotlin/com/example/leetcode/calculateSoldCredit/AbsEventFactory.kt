package com.example.leetcode.calculateSoldCredit

import java.math.BigDecimal
import java.math.RoundingMode
import java.time.OffsetDateTime

@SuppressWarnings("detekt:TooManyFunctions")
object AbsEventFactory {

  fun newPaymentEvent(changeStatus: ChangeStatus?, paymentDataList: List<PaymentData>) = PaymentsEvent(
      paymentDataList.flatMap { payment ->
        val distribution = payment.paymentDistribution.firstOrNull()
        listOf(
            PaymentEvent(
                solvaPaymentId = payment.creditPaymentId,
                targetId = payment.creditId,
                baseAmount = payment.paymentAmount,
                paymentSource = CreditPaymentSource.valueOf(payment.paymentSource.name),
                distributionDate = payment.paymentDate,
                currency = Currency.KZT,
                eventTime = OffsetDateTime.now(),
                distributions = distribution?.let { toDistributionList(it) } ?: listOf()
            )
        )
      },
      changeStatus = changeStatus
  )

  private fun toDistributionList(distributionLog: PaymentDistributionLog) = toDistribution(
      Distribution(DistributionType.EXPIRED_MAIN_DEBT,
          distributionLog.expiredPrincipal.num()
              .plus(distributionLog.expiredNonCapitalizedDebt)
              .double()
      ),
      Distribution(DistributionType.EXPIRED_MAIN_REWARD,
          distributionLog.expiredInterest ?: 0.0),
      Distribution(DistributionType.EXPIRED_REWARD,
          distributionLog.interestExpiredOnly ?: 0.0),
      Distribution(DistributionType.DEBT,
          distributionLog.principal.num()
              .plus(distributionLog.nonCapitalizedDebt)
              .minus(distributionLog.expiredPrincipal)
              .minus(distributionLog.expiredNonCapitalizedDebt)
              .double()
      ),
      Distribution(DistributionType.REWARD,
          distributionLog.interest.num()
              .minus(distributionLog.expiredInterest)
              .double()
      )
  )

  fun toCreditStateDto(lastCreditCalculations: CreditCalculations?) =
      lastCreditCalculations?.run {
        CreditStateDto(
            balanceDebt = BigDecimal("$mainDebt")
                .minus(BigDecimal("$expiredMainDebt"))
                .plus(BigDecimal("$nonCapitalizedDebt"))
                .minus(BigDecimal("$expiredNonCapitalizedDebt"))
                .toDouble(),
            balanceReward = BigDecimal("$percentDebt")
                .minus(BigDecimal("$expiredPercentDebt"))
                .toDouble(),
            balanceExpiredDebt = BigDecimal("$expiredMainDebt")
                .plus(BigDecimal("$expiredNonCapitalizedDebt"))
                .toDouble(),
            balanceExpiredReward = BigDecimal("$expiredPercentDebt")
                .plus(BigDecimal("$percentExpiredDebt"))
                .toDouble(),
//            balanceOverpay = BigDecimal("$overpaid")
//                .toDouble(),
//            distributedPayments = toPaymentDtoList(distributedPayments)
        )
      }

  //
//  private fun toDistributionList(creditCalculations: CreditCalculations) = toDistribution(
//    Distribution(DistributionType.DEBT,
//      creditCalculations.mainDebt.num()
//        .minus(creditCalculations.expiredMainDebt)
//        .plus(creditCalculations.nonCapitalizedDebt)
//        .minus(creditCalculations.expiredNonCapitalizedDebt)
//        .double()
//    ),
//    Distribution(DistributionType.REWARD, creditCalculations.percentDebt.num()
//      .minus(creditCalculations.expiredPercentDebt)
//      .double()),
//    Distribution(DistributionType.EXPIRED_REWARD,
//      creditCalculations.expiredPercentDebt.num()
//        .plus(creditCalculations.expiredNonCapitalizedDebt)
//        .double()
//    ),
//    Distribution(DistributionType.EXPIRED_MAIN_DEBT, creditCalculations.expiredMainDebt.num()
//      .plus(creditCalculations.expiredNonCapitalizedDebt)
//      .toDouble()),
//    Distribution(DistributionType.EXPIRED_MAIN_REWARD, creditCalculations.expiredPercentDebt.num()
//      .plus(creditCalculations.percentExpiredDebt)
//      .toDouble())
//  )
//
//  fun newAccumulatedCalculationEvent(events: List<CalculationFlowEvent>) = events.last().copy(
//    calculationEvent = events.last().calculationEvent?.copy(
//      calculations = toCalculation(
//        accumulateCalculations(events, REWARD),
//        accumulateCalculations(events, EXPIRED_REWARD)
//      ),
//      expiration = events.mapNotNull { it.calculationEvent?.expiration }.lastOrNull()?.copy(
//        expiredCalculations = toCalculation(
//          accumulateExpiredCalculations(events, EXPIRED_MAIN_DEBT),
//          accumulateExpiredCalculations(events, EXPIRED_MAIN_REWARD)
//        )
//      )
//    )
//  )
//
//  private fun accumulateValues(calc: List<Calculation>, type: CalculationType) = calc
//    .filter { c -> c.type == type }
//    .sumOf { c -> BigDecimal("${c.value}") }
//    .toDouble()
//
//  private fun accumulateExpiredCalculations(events: List<CalculationFlowEvent>, type: CalculationType) = Calculation(
//    type,
//    accumulateValues(
//      events.flatMap { event -> event.calculationEvent?.expiration?.expiredCalculations ?: listOf() },
//      type
//    )
//  )
//
//  private fun accumulateCalculations(events: List<CalculationFlowEvent>, type: CalculationType) = Calculation(
//    type,
//    accumulateValues(events.flatMap { event -> event.calculationEvent?.calculations ?: listOf() }, type)
//  )
//
//  fun newCalculationEvent(
//    calcDate: LocalDate,
//    calculations: CreditCalculations,
//    expiration: AbsExpiration?,
//    paymentDataList: List<PaymentData>?,
//  ) = CalculationFlowEvent(
//    messageType = CALCULATION,
//    calculationEvent = CalculationEvent(
//      creditId = "${calculations.creditId}",
//      calculationId = "${calculations.id}",
//      calculationDate = calcDate,
//      calculations = toCalculation(
//        Calculation(REWARD, calculations.percentCharge),
//        Calculation(EXPIRED_REWARD, calculations.percentExpiredCharge)
//      ),
//      expiration = expiration?.run {
//        Expiration(
//          paymentDate = paymentDate,
//          expiredCalculations = toCalculation(
//            Calculation(EXPIRED_MAIN_DEBT, expiredMainDebt),
//            Calculation(EXPIRED_MAIN_REWARD, expiredMainReward)
//          )
//        )
//      },
//      payments = paymentDataList?.let(this::toCalculationPaymentDto),
//      eventTime = OffsetDateTime.now()
//    )
//  )
//
//  private fun toCalculationPaymentDto(paymentDataList: List<PaymentData>) = paymentDataList.map { paymentData ->
//    kz.solvabank.abs.model.calculation.PaymentDto(
//      solvaPaymentId = checkNotNull(paymentData.creditPaymentId),
//      paymentSource = paymentData.paymentSource.name,
//      currency = paymentData.currency.name,
//      baseAmount = 0.0,
//      distribution = paymentData.paymentDistribution
//        .first()
//        .let(this::toDistributionList)
//        .map { d -> kz.solvabank.abs.model.calculation.Distribution(d.type.name, d.value) }
//    )
//  }
//
//  fun toTopUpDto(topUpPaymentData: TopUpPaymentData?) = topUpPaymentData?.run {
//    TopUpDto(
//      oldCreditId = oldCreditId,
//      totalRefinanceAmount = refinancedAmount,
//      refinanceOverpayAmount = refinanceOverpaidAmount,
//      payments = paymentDataList.map { paymentData ->
//        toPaymentDto(paymentData)
//      })
//  }
//
//  fun toPaymentDto(paymentData: PaymentData): PaymentDto {
//    val isRefinancePayment = paymentData.paymentSource.name.equals(PaymentSource.SELF_REFINANCE.name)
//    return PaymentDto(
//      solvaPaymentId = checkNotNull(paymentData.creditPaymentId),
//      paymentSource = paymentData.paymentSource.name,
//      currency = paymentData.currency.name,
//      baseAmount = if (isRefinancePayment) paymentData.paymentAmount else 0.0,
//      distribution = paymentData.paymentDistribution
//        .first()
//        .let { pd -> toDistributionList(pd) }
//        .map { d -> RefinanceDistribution(d.type.name, d.value) }
//    )
//  }
//
//  fun newCalculationEndProcess() = CalculationFlowEvent(PROCESS_END)
//
  private fun toDistribution(vararg distributions: Distribution) = distributions
      .filter { it.value >= MIN_BORDER_VALUE }
      .toList()

  //
//  private fun toCalculation(vararg calculations: Calculation) = calculations
//    .filter { it.value >= MIN_BORDER_VALUE }
//    .toList()
//
  private fun Double?.num() = if (this != null) {
    BigDecimal(this.toString())
  } else {
    BigDecimal.ZERO
  }

  private fun BigDecimal.plus(num: Double?) = this.plus(num.num())

  private fun BigDecimal.minus(num: Double?) = this.minus(num.num())

  private fun BigDecimal.double() = this.setScale(SCALE, RoundingMode.HALF_UP).toDouble()
//
//  fun alignWithAbsCurrentDate(paymentDataList: List<PaymentData>, absCurrentDate: LocalDate) = paymentDataList
//    .map { paymentData ->
//      paymentData.copy(
//        paymentDate = absCurrentDate,
//        paymentDistribution = paymentData.paymentDistribution
//          .map { pd -> pd.apply { distributionDate = absCurrentDate } }
//          .toList()
//      )
//    }
//    .toList()
}
