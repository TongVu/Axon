package com.axonactive.programmingChallenges.sum_calculator;

public class SimpleCalculatorDemo {
    public static void main(String[] args) {
        SimpleCalculator cal = new SimpleCalculator();
        cal.setFirstNumber(5.0);
        cal.setSecondNumber(4);

        System.out.println("add = " + cal.getAdditionResult());
        System.out.println("subtract = " + cal.getSubtractionResult());

        cal.setSecondNumber(5.25);
        cal.setSecondNumber(0);
        System.out.println("Mulptiply = " + cal.getMultiplecationResult());
        System.out.println("divide = " + cal.getDivisionResult());
    }
}

