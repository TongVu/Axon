package com.axonactive.problems.Payroll;

import java.io.IOException;

public class EmptyIDException extends IOException {
    public EmptyIDException(){
        super(new IllegalArgumentException("ID shouldn't be empty"));
    }
}
