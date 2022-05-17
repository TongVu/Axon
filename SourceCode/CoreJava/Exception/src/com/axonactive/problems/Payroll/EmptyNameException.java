package com.axonactive.problems.Payroll;

public class EmptyNameException extends Exception {
    public EmptyNameException(){
        super(new IllegalArgumentException("String wasn't given"));
    }
}
