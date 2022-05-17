package com.axonactive.testing.junit5.projects;

public class PayrollRecord {
    private double nWorkingHours;
    private double hourlyPayRate;

    public double getnWorkingHours() {
        return nWorkingHours;
    }

    public void setnWorkingHours(double nWorkingHours) {
        if (nWorkingHours <= 0)
            throw new IllegalArgumentException("Should larger than 0");
        else
            this.nWorkingHours = nWorkingHours;
    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) {
        if (hourlyPayRate <= 0)
            throw new IllegalArgumentException("Should larger than 0");
        else
            this.hourlyPayRate = hourlyPayRate;
    }

    public double calculateGrossPay() {
        return nWorkingHours * hourlyPayRate;
    }
}
