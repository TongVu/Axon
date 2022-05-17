package com.axonactive.programmingChallenges.ShiftSupervisor;
import com.axonactive.programmingChallenges.EmployeeAndProductionWorker.Employee;

/*
/shift supervisor

/Fields:
    - salary: double
    - yearlyBonus: double (only earns bonus when meet production goals)

/Methods:
    -getInfo() : void
    -annualSalary() : double

 */

public class ShiftSupervisor extends Employee{
    private double salary;
    private double yearlyBonus;

    public ShiftSupervisor(String name, String empNumb, String hireDate){
        super(name, empNumb, hireDate);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getYearlyBonus() {
        return yearlyBonus;
    }

    public void setYearlyBonus(double yearlyBonus) {
        this.yearlyBonus = yearlyBonus;
    }

    public double annualSalary(){
        return getSalary() * 12;
    }

    public void getInfo(){
        System.out.println("Name: " + getName());
        System.out.println("Id:  " + getEmployeeNumber());
        System.out.println("Hire date: " + getHireDate());
        System.out.println("Salary: " + getSalary());
        System.out.println("Annual salary: " + annualSalary());
        System.out.println("Annual bonus: " + getYearlyBonus());
    }
}
