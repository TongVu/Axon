package com.axonactive.problems.Payroll;

public class InvalidPayRateException extends Exception{
    public InvalidPayRateException(){
        super(new IllegalArgumentException("Payrate is a postitive number and smaller than 25"));
    }
}
