package com.axonactive.problems.Payroll;

public class HoursWorkedException extends Exception{
    public HoursWorkedException(){
        super(new IllegalArgumentException("Number is positive and smaller than 84"));
    }
}
