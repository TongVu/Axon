package Problem3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HourlyEmployee extends Employee{
    private double wage;
    private double workingHours;

    HourlyEmployee(){
        super();
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    public String toString(){
        return "return a string";
    }
}
