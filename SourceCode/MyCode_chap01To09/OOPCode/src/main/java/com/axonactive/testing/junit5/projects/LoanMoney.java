package com.axonactive.testing.junit5.projects;

import java.util.Scanner;

public class LoanMoney {
    private double salary;
    private int years;

    public void setSalary(double salary) {
        if (salary < 0)
            throw new IllegalArgumentException("Salary should be positive");
        else
            this.salary = salary;
    }

    public void setYears(int years) {
        if (years < 0)
            throw new IllegalArgumentException("Years should be positive");
        else
            this.years = years;
    }

    public double getSalary() {
        return salary;
    }

    public int getYears() {
        return years;
    }


    public boolean checkSalary() {
        return salary >= 2000;
    }

    public boolean checkYears() {
        return years >= 2;
    }

    public boolean isLegal() {
        return (checkSalary() && checkYears());
    }
}
