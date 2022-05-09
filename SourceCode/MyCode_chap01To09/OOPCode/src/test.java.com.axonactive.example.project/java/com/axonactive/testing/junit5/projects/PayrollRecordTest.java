package com.axonactive.testing.junit5.projects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayrollRecordTest {
    @Test
    @DisplayName("Hours <= 0")
    void setWorkingHours_shouldReturnIlligalArgumentException_workingHoursSmallerThanZeroOrEqual() {
        var payRollRecord = new PayrollRecord();

        assertThrows(IllegalArgumentException.class,
                () -> payRollRecord.setnWorkingHours(-1));
    }

    @Test
    @DisplayName("Payrate <= 0")
    void setPayRate_shouldReturnIlligalArgumentException_payRateSmallerThanZeroOrEqual() {
        var payRollRecord = new PayrollRecord();

        assertThrows(IllegalArgumentException.class,
                () -> payRollRecord.setHourlyPayRate(0));
    }
    @Test
    @DisplayName("Positive working hours and positive pay rate")
    void calculateGrossPay_shouldReturnGrossPay_positiveWorkingHoursAndPositivePayRate() {
        var payRollRecord = new PayrollRecord();

        payRollRecord.setnWorkingHours(40);
        payRollRecord.setHourlyPayRate(25);

        assertEquals(1000.0, payRollRecord.calculateGrossPay());
    }

}