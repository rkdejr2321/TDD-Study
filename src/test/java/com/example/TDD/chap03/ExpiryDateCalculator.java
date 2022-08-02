package com.example.TDD.chap03;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData) {
        int addMonths = payData.getPayAmount() == 100_000? 12 : payData.getPayAmount() / 10000;
        if(payData.getFirstBillingDate() != null) {
            return expiryDateUsingFirstBillingDate(payData, addMonths);
        } else {
            return payData.getBillingDate().plusMonths(addMonths);
        }
    }

    private LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addMonths) {
        LocalDate candidateExp = payData.getBillingDate().plusMonths(addMonths);
        final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
        if(dayOfFirstBilling != candidateExp.getDayOfMonth()) {
            final int dayLenOfCandiMon = YearMonth.from(candidateExp).lengthOfMonth();
            if(dayLenOfCandiMon < payData.getFirstBillingDate().getDayOfMonth()) {
                return candidateExp.withDayOfMonth(dayLenOfCandiMon);
            }
            return candidateExp.withDayOfMonth(dayOfFirstBilling);
        } else {
            return candidateExp;
        }
    }
}
