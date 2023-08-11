package com.example.leetcode.calculateSoldCredit;




import lombok.Builder;

import java.util.Date;

@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class CreditCalculations {

    private Long creditId;                           //credit.id
    private CreditCalculations prevCreditCalculation;
    private Long prevCreditCalculationId;            //credit_calculations.id за предыдущий день
    private Date calculationDate;                    //дата расчета
    private Double percentCharge = 0d;               //сумма процентов за текущий день
    private Double penaltyCharge = 0d;               //сумма штрафа начисленная в этот день

    private Double percentDebt = 0d;                 //сумма долга по процентам (на конец дня)
    private Double expiredPercentDebt = 0d;          //сумма долга по процентам (на конец дня)
    private Double penaltyDebt = 0d;                 //сумма долга штрафа (на конец дня)
    private Double mainDebt = 0d;                    // сумма долга по основной сумме (на конец дня)
    private Double expiredMainDebt;                  //просроченный основной долг
    private Double fullRepaymentAmount = 0d;         // сумма к погашению на текущую дату
    private Double conditionalMainDebt = 0d;
    private Double totalDebt = 0d;                   //сумма долга на текущий день (на конец дня)
    private Double expiredDebt = 0d;                 // сумма просроченной задолженности (на конец дня)

    private Double forgivenAmount = 0d;  // сумма прощенного долга
    private Double bonusAmount = 0d;     // сумма бонусов за текущий день
    private Double paymentsAmount = 0d;  //пришедшие суммы от заемщика
    private Double commissionAmount = 0d;     //комиссии за услуги (продления)
    private Double overpaid = 0d;     //сумма переплаты
    private Double totalPayed = 0d;  //всего внесено

    private Double mainDebtRepaid = 0d;     //погашено по основному долгу
    private Double percentRepaid = 0d;      //погашено процентов
    private Double penaltyRepaid = 0d;      //погашено штрафов

    private long statusReasonCode;          //код указывающий причину установки статуса
    private long statusDaysCount;           //кол-во дней в данном статусе подряд
    private Long expiredDaysCount = 0L;          //кол-во дней просрочки на текущий момент
    private Long expiredActualDaysCount = 0L;          //кол-во дней просрочки с учетом продлений на текущий момент

    private Integer daysBetweenLastPayment = 0;    //кол-во дней от последнего платежа (при этом если заем активный, то значение = 0) MMRU-8631
    private Integer paymentScheduleNumber;
    private Integer paymentScheduleExpiredNumber;
    private Integer expiredDaysCountWithoutRollover = 0;    //кол-во просроченных дней без учета дней на продление

    private Double percentExpiredCharge;
    private Double percentExpiredDebt;
    private Double percentExpiredRepaid;

    private Double nonCapitalizedDebt;               // сумма по некапитализированному долгу на конец дня
    private Double expiredNonCapitalizedDebt;        // сумма просроченного некапитализированного долга на конец дня
    private Double nonCapitalizedDebtRepaid;         // погашено по некапитализированному долгу

    private Double nonRefinancePenaltyCharge;             //размер пени за не рефинансирование долга начисленной на конец дня
    private Double nonRefinancePenaltyDebt;               //размер пени за не рефинансирование долга оставшейся на конец дня
    private Double expiredNonRefinancePenalty;            //размер просроченной пени за не нерефин. долга на конец дня
    private Double nonRefinancePenaltyRepaid;             //погашено пени за не рефинансирование долга
    private Double nonRefinancePenaltyForgivenCharge;     //прощено пени за не рефинансирование долга
    private Double nonRefinancePenaltyForgivenSum;        //прощено пени за не рефинансирование долга

    public Long getCreditId() {
        return creditId;
    }

    public void setCreditId(Long creditId) {
        this.creditId = creditId;
    }

    public CreditCalculations getPrevCreditCalculation() {
        return prevCreditCalculation;
    }

    public void setPrevCreditCalculation(CreditCalculations prevCreditCalculation) {
        this.prevCreditCalculation = prevCreditCalculation;
    }

    public Long getPrevCreditCalculationId() {
        return prevCreditCalculationId;
    }

    public void setPrevCreditCalculationId(Long prevCreditCalculationId) {
        this.prevCreditCalculationId = prevCreditCalculationId;
    }

    public Date getCalculationDate() {
        return calculationDate;
    }

    public void setCalculationDate(Date calculationDate) {
        this.calculationDate = calculationDate;
    }

    public Double getPercentCharge() {
        return percentCharge;
    }

    public void setPercentCharge(Double percentCharge) {
        this.percentCharge = percentCharge;
    }

    public Double getPenaltyCharge() {
        return penaltyCharge;
    }

    public void setPenaltyCharge(Double penaltyCharge) {
        this.penaltyCharge = penaltyCharge;
    }

    public Double getPercentDebt() {
        return percentDebt;
    }

    public void setPercentDebt(Double percentDebt) {
        this.percentDebt = percentDebt;
    }

    public Double getExpiredPercentDebt() {
        return expiredPercentDebt;
    }

    public void setExpiredPercentDebt(Double expiredPercentDebt) {
        this.expiredPercentDebt = expiredPercentDebt;
    }

    public Double getPenaltyDebt() {
        return penaltyDebt;
    }

    public void setPenaltyDebt(Double penaltyDebt) {
        this.penaltyDebt = penaltyDebt;
    }

    public Double getMainDebt() {
        return mainDebt;
    }

    public void setMainDebt(Double mainDebt) {
        this.mainDebt = mainDebt;
    }

    public Double getExpiredMainDebt() {
        return expiredMainDebt;
    }

    public void setExpiredMainDebt(Double expiredMainDebt) {
        this.expiredMainDebt = expiredMainDebt;
    }

    public Double getFullRepaymentAmount() {
        return fullRepaymentAmount;
    }

    public void setFullRepaymentAmount(Double fullRepaymentAmount) {
        this.fullRepaymentAmount = fullRepaymentAmount;
    }

    public Double getConditionalMainDebt() {
        return conditionalMainDebt;
    }

    public void setConditionalMainDebt(Double conditionalMainDebt) {
        this.conditionalMainDebt = conditionalMainDebt;
    }

    public Double getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(Double totalDebt) {
        this.totalDebt = totalDebt;
    }

    public Double getExpiredDebt() {
        return expiredDebt;
    }

    public void setExpiredDebt(Double expiredDebt) {
        this.expiredDebt = expiredDebt;
    }

    public Double getForgivenAmount() {
        return forgivenAmount;
    }

    public void setForgivenAmount(Double forgivenAmount) {
        this.forgivenAmount = forgivenAmount;
    }

    public Double getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(Double bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public Double getPaymentsAmount() {
        return paymentsAmount;
    }

    public void setPaymentsAmount(Double paymentsAmount) {
        this.paymentsAmount = paymentsAmount;
    }

    public Double getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(Double commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    public Double getOverpaid() {
        return overpaid;
    }

    public void setOverpaid(Double overpaid) {
        this.overpaid = overpaid;
    }

    public Double getTotalPayed() {
        return totalPayed;
    }

    public void setTotalPayed(Double totalPayed) {
        this.totalPayed = totalPayed;
    }

    public Double getMainDebtRepaid() {
        return mainDebtRepaid;
    }

    public void setMainDebtRepaid(Double mainDebtRepaid) {
        this.mainDebtRepaid = mainDebtRepaid;
    }

    public Double getPercentRepaid() {
        return percentRepaid;
    }

    public void setPercentRepaid(Double percentRepaid) {
        this.percentRepaid = percentRepaid;
    }

    public Double getPenaltyRepaid() {
        return penaltyRepaid;
    }

    public void setPenaltyRepaid(Double penaltyRepaid) {
        this.penaltyRepaid = penaltyRepaid;
    }

    public long getStatusReasonCode() {
        return statusReasonCode;
    }

    public void setStatusReasonCode(long statusReasonCode) {
        this.statusReasonCode = statusReasonCode;
    }

    public long getStatusDaysCount() {
        return statusDaysCount;
    }

    public void setStatusDaysCount(long statusDaysCount) {
        this.statusDaysCount = statusDaysCount;
    }

    public Long getExpiredDaysCount() {
        return expiredDaysCount;
    }

    public void setExpiredDaysCount(Long expiredDaysCount) {
        this.expiredDaysCount = expiredDaysCount;
    }

    public Long getExpiredActualDaysCount() {
        return expiredActualDaysCount;
    }

    public void setExpiredActualDaysCount(Long expiredActualDaysCount) {
        this.expiredActualDaysCount = expiredActualDaysCount;
    }

    public Integer getDaysBetweenLastPayment() {
        return daysBetweenLastPayment;
    }

    public void setDaysBetweenLastPayment(Integer daysBetweenLastPayment) {
        this.daysBetweenLastPayment = daysBetweenLastPayment;
    }

    public Integer getPaymentScheduleNumber() {
        return paymentScheduleNumber;
    }

    public void setPaymentScheduleNumber(Integer paymentScheduleNumber) {
        this.paymentScheduleNumber = paymentScheduleNumber;
    }

    public Integer getPaymentScheduleExpiredNumber() {
        return paymentScheduleExpiredNumber;
    }

    public void setPaymentScheduleExpiredNumber(Integer paymentScheduleExpiredNumber) {
        this.paymentScheduleExpiredNumber = paymentScheduleExpiredNumber;
    }

    public Integer getExpiredDaysCountWithoutRollover() {
        return expiredDaysCountWithoutRollover;
    }

    public void setExpiredDaysCountWithoutRollover(Integer expiredDaysCountWithoutRollover) {
        this.expiredDaysCountWithoutRollover = expiredDaysCountWithoutRollover;
    }

    public Double getPercentExpiredCharge() {
        return percentExpiredCharge;
    }

    public void setPercentExpiredCharge(Double percentExpiredCharge) {
        this.percentExpiredCharge = percentExpiredCharge;
    }

    public Double getPercentExpiredDebt() {
        return percentExpiredDebt;
    }

    public void setPercentExpiredDebt(Double percentExpiredDebt) {
        this.percentExpiredDebt = percentExpiredDebt;
    }

    public Double getPercentExpiredRepaid() {
        return percentExpiredRepaid;
    }

    public void setPercentExpiredRepaid(Double percentExpiredRepaid) {
        this.percentExpiredRepaid = percentExpiredRepaid;
    }

    public Double getNonCapitalizedDebt() {
        return nonCapitalizedDebt;
    }

    public void setNonCapitalizedDebt(Double nonCapitalizedDebt) {
        this.nonCapitalizedDebt = nonCapitalizedDebt;
    }

    public Double getExpiredNonCapitalizedDebt() {
        return expiredNonCapitalizedDebt;
    }

    public void setExpiredNonCapitalizedDebt(Double expiredNonCapitalizedDebt) {
        this.expiredNonCapitalizedDebt = expiredNonCapitalizedDebt;
    }

    public Double getNonCapitalizedDebtRepaid() {
        return nonCapitalizedDebtRepaid;
    }

    public void setNonCapitalizedDebtRepaid(Double nonCapitalizedDebtRepaid) {
        this.nonCapitalizedDebtRepaid = nonCapitalizedDebtRepaid;
    }

    public Double getNonRefinancePenaltyCharge() {
        return nonRefinancePenaltyCharge;
    }

    public void setNonRefinancePenaltyCharge(Double nonRefinancePenaltyCharge) {
        this.nonRefinancePenaltyCharge = nonRefinancePenaltyCharge;
    }

    public Double getNonRefinancePenaltyDebt() {
        return nonRefinancePenaltyDebt;
    }

    public void setNonRefinancePenaltyDebt(Double nonRefinancePenaltyDebt) {
        this.nonRefinancePenaltyDebt = nonRefinancePenaltyDebt;
    }

    public Double getExpiredNonRefinancePenalty() {
        return expiredNonRefinancePenalty;
    }

    public void setExpiredNonRefinancePenalty(Double expiredNonRefinancePenalty) {
        this.expiredNonRefinancePenalty = expiredNonRefinancePenalty;
    }

    public Double getNonRefinancePenaltyRepaid() {
        return nonRefinancePenaltyRepaid;
    }

    public void setNonRefinancePenaltyRepaid(Double nonRefinancePenaltyRepaid) {
        this.nonRefinancePenaltyRepaid = nonRefinancePenaltyRepaid;
    }

    public Double getNonRefinancePenaltyForgivenCharge() {
        return nonRefinancePenaltyForgivenCharge;
    }

    public void setNonRefinancePenaltyForgivenCharge(Double nonRefinancePenaltyForgivenCharge) {
        this.nonRefinancePenaltyForgivenCharge = nonRefinancePenaltyForgivenCharge;
    }

    public Double getNonRefinancePenaltyForgivenSum() {
        return nonRefinancePenaltyForgivenSum;
    }

    public void setNonRefinancePenaltyForgivenSum(Double nonRefinancePenaltyForgivenSum) {
        this.nonRefinancePenaltyForgivenSum = nonRefinancePenaltyForgivenSum;
    }
}

