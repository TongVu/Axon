package bank_loan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankLoanTest {

    @Test
    void isAnnualSalaryValid_shouldReturnTrue_whenAnnualSalaryFromThirtyThousandOrAbove(){
        assertTrue(new BankLoan(30000, 1).isAnnualSalaryValid());
        assertTrue(new BankLoan(34000.5, 2).isAnnualSalaryValid());
        assertTrue(new BankLoan(41000, 0).isAnnualSalaryValid());
    }
    @Test
    void isAnnualSalaryValid_shouldReturnFalse_whenAnnualSalaryBelowThirtyThousand(){
        assertFalse(new BankLoan(29999, 1).isAnnualSalaryValid());
        assertFalse(new BankLoan(0, 2).isAnnualSalaryValid());
        assertFalse(new BankLoan(1000, 0).isAnnualSalaryValid());
    }

    @Test
    void isYearHasWorkedValid_shouldReturnTrue_whenYearHasWorkedFromTwoOrAbove(){
        assertTrue(new BankLoan(10000, 2).isYearHasWorkedValid());
        assertTrue(new BankLoan(10000, 3).isYearHasWorkedValid());
        assertTrue(new BankLoan(10000, 10).isYearHasWorkedValid());
    }

    @Test
    void isYearHasWorkedValid_shouldReturnFalse_whenYearHasWorkedBelowTwo(){
        assertFalse(new BankLoan(10000, 1).isYearHasWorkedValid());
        assertFalse(new BankLoan(10000, 0).isYearHasWorkedValid());
    }

    @Test
    void isCustomerValidToLoan_shouldReturnFalse_whenIsYearHasWorkedValidFalseOrIsAnnualSalaryValidFalse() {
        assertFalse(new BankLoan(29000, 1).isCustomerValidToLoan());
        assertFalse(new BankLoan(31000, 1).isCustomerValidToLoan());
        assertFalse(new BankLoan(29000, 2).isCustomerValidToLoan());
        assertFalse(new BankLoan(29999, 2).isCustomerValidToLoan());
    }

    @Test
    void isCustomerValidToLoan_shouldReturnTrue_whenIsYearHasWorkedValidTrueAndIsAnnualSalaryValidTrue() {
        assertTrue(new BankLoan(30000, 2).isCustomerValidToLoan());
        assertTrue(new BankLoan(31000, 3).isCustomerValidToLoan());
    }
}