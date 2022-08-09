package com.example.TDD.chap03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ExpiryDateCalculatorTest {

    @Test
    void 만원_납부하면_한달_뒤가_만료일이_됨() {
        assertExpireDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019,3,1))
                        .payAmount(10000)
                        .build(),
                LocalDate.of(2019,4,1));
    }

    @Test
    void 납부일과_한달_뒤_일자가_같지_않음() {
        assertExpireDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019,1,31))
                        .payAmount(10000)
                        .build(),
                LocalDate.of(2019,2,28));
    }
    @Test
    void 첫_납부일과_만료일_일자가_다를때_만원_납부() {
        PayData payData = PayData.builder()
                .firstBillingDate(LocalDate.of(2019, 1, 31))
                .billingDate(LocalDate.of(2019, 2, 28))
                .payAmount(10000)
                .build();
        assertExpireDate(payData, LocalDate.of(2019,3,31));

        PayData payData2 = PayData.builder()
                .firstBillingDate(LocalDate.of(2019,5,31))
                .billingDate(LocalDate.of(2019,6,30))
                .payAmount(10000)
                .build();
        assertExpireDate(payData2, LocalDate.of(2019,7,31));
    }

    @Test
    void 이만원_이상_납부하면_비례해서_만료일_계산() {
        PayData payData = PayData.builder()
                .billingDate(LocalDate.of(2019, 3, 1))
                .payAmount(20000)
                .build();
        assertExpireDate(payData, LocalDate.of(2019,5,1));

        PayData payData2 = PayData.builder()
                .billingDate(LocalDate.of(2019, 3, 1))
                .payAmount(30000)
                .build();
        assertExpireDate(payData2, LocalDate.of(2019,6,1));

        assertExpireDate(
                PayData.builder()
                        .firstBillingDate(LocalDate.of(2019,1,31))
                        .billingDate(LocalDate.of(2019,2,28))
                        .payAmount(20000)
                        .build(),
                LocalDate.of(2019,4,30)
        );
    }

    @Test
    void 십만원을_납부하면_1년_제공() {
        assertExpireDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019,1,28))
                        .payAmount(100_000)
                        .build(),
                LocalDate.of(2020,1,28)
        );
    }

    private void assertExpireDate(PayData payData, LocalDate expireDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate realExpireDate = cal.calculateExpiryDate(payData);
        assertEquals(expireDate, realExpireDate);
    }
}
