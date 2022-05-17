package com.axonactive.testing.junit5.projects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanMoneyTest {

    @Test
    @DisplayName("Salary is negative")
    void setSalary_shouldReturnIllegalArgumentException_salarySmallerThanZero() {
        var loanMoney = new LoanMoney();

        assertThrows(IllegalArgumentException.class,
                () -> loanMoney.setSalary(-12.5));
    }

    @Test
    @DisplayName("Years is negative")
    void setYears_shouldReturnIllegalArgumentException_yearsSmallerThanZero() {
        var loanMoney = new LoanMoney();

        assertThrows(IllegalArgumentException.class,
                () -> loanMoney.setYears(-2));
    }

    @Test
    @DisplayName("Get salary is smaller than $2000")
    void checkSalary_shouldReturnFalse_getSalarySmallerThanTwoThousand() {
        var loanMoney = new LoanMoney();
        loanMoney.setSalary(1000);

        assertEquals(false, loanMoney.getSalary() >= 2000);
    }

    @Test
    @DisplayName("Get salary is equal or larger than $2000")
    void checkSalary_shouldReturnTrue_getSalaryEqualOrLargerThanTwoThousand() {
        var loanMoney = new LoanMoney();

        loanMoney.setSalary(2000);
        assertEquals(true, loanMoney.getSalary() >= 2000);
    }

    @Test
    @DisplayName("Years is less than 2 years")
    void checkYears_shouldReturnFalse_getYearsSmallerThanTwo() {
        var loanMoney = new LoanMoney();
        loanMoney.setYears(1);

        assertEquals(false, loanMoney.getYears() >= 2);
    }

    @Test
    @DisplayName("Years is equal or more than 2 years")
    void checkYears_shouldReturnTrue_getYearsEqualOrLargerThanTwo() {
        var loanMoney = new LoanMoney();
        loanMoney.setYears(2);

        assertEquals(true, loanMoney.getYears() >= 2);
    }

    @Test
    @DisplayName("Check years false and check salary false")
    void isLegal_shouldReturnFalse_checkYearAndCheckSalaryFalse() {
        var loanMoney = new LoanMoney();
        loanMoney.setYears(1);
        loanMoney.setSalary(1000);

        assertEquals(false, loanMoney.isLegal());
    }

    @Test
    @DisplayName("Check years false and check salary true")
    void isLegal_shouldReturnFalse_checkYearFalseAndCheckSalaryTrue() {
        var loanMoney = new LoanMoney();
        loanMoney.setYears(1);
        loanMoney.setSalary(2000);

        assertEquals(false, loanMoney.isLegal());
    }

    @Test
    @DisplayName("Check years true and check salary false")
    void isLegal_shouldReturnFalse_checkYearTrueAndCheckSalaryFalse() {
        var loanMoney = new LoanMoney();
        loanMoney.setYears(2);
        loanMoney.setSalary(1000);

        assertEquals(false, loanMoney.isLegal());
    }

    @Test
    @DisplayName("Check years true and check salary true")
    void isLegal_shouldReturnFalse_checkYearAndCheckSalaryTrue() {
        var loanMoney = new LoanMoney();
        loanMoney.setYears(2);
        loanMoney.setSalary(2000);

        assertEquals(true, loanMoney.isLegal());
    }
}