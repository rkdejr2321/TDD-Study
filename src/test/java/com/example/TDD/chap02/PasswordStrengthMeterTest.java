package com.example.TDD.chap02;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordStrengthMeterTest {
    PasswordStrengthMeter meter = new PasswordStrengthMeter();


    @Test
    void meetsAllCriteria_Then_Strong() {
        //given

        //when
        PasswordStrength result = meter.meter("ab12!@AB");

        //then
        assertEquals(PasswordStrength.STRONG, result);
    }

    @Test
    void meetsOtherCriteria_except_for_Length_then_Normal() {
        //given

        //when
        PasswordStrength result = meter.meter("ab12!@A");

        //then
        assertEquals(PasswordStrength.NORMAL, result);
    }
}
