package com.axonactive.programmingChallenges.EmployeeAndProductionWorker;

/*
/ProductionWorker

/Fields:
    -Shift: int
        :_ day shift <=> shift == 1
        :_ night shift <=> shift == 2
    -Hourly pay rate: double
 */

public class ProductionWorker extends Employee {
    private int shift;
    private double payRate; //Hourly pay rate

    public ProductionWorker() {
    }

    ;

    public ProductionWorker(String name, String empNumb, String hireDate) {
        super(name, empNumb, hireDate);
    }

    public String getShift() {
        if(shift == 1)
            return "Day shift";
        else if(shift == 2)
            return "Night shift";
        else
            throw new IllegalArgumentException(
                    "There is no such shift existed.");
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }


    public void getInfo() {
        System.out.println("Name: " + getName());
        System.out.println("ID: " + getEmployeeNumber());
        System.out.println("Hire date: " + getHireDate());
        System.out.println("Shift: " + getShift());
        System.out.println("Pay rate: " + getPayRate());
    }
}
