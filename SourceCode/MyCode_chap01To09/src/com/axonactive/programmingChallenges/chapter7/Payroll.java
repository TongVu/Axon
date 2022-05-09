package com.axonactive.programmingChallenges.chapter7;

import java.util.Scanner;

public class Payroll {
    // this for easier testing
    static int NUMBER_OF_PEOPLE = 3;

    private Integer[] employeeID = {
            5658845, 4520125, 7895122, 8777541,
            8451277, 1302850, 7580489
    };
    private Integer[] hours = new Integer[NUMBER_OF_PEOPLE];
    private Double[] payRate = new Double[NUMBER_OF_PEOPLE];
    private Double[] wages = new Double[NUMBER_OF_PEOPLE];

    public Payroll() {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < NUMBER_OF_PEOPLE; i++) {
            System.out.println((i + 1) + ". Employee Id: " + getId(i));
        }
        System.out.println("____________________________________________");

        for (int i = 0; i < NUMBER_OF_PEOPLE; i++) {
            do {
                System.out.print("Working hours for " + getId(i) + ": ");
                setHours(i, input.nextInt());
            } while (hours[i] < 0);


            do {
                System.out.print("Pay rate is more than 6 dollars/hour. Pay rate for " + getId(i) + ": $");
                setPayRate(i, input.nextDouble());
            } while (payRate[i] < 6);

            setWages(i);
            // line break
            System.out.println();
        }
    }

    public void setHours(int index, int hours) {
        this.hours[index] = hours;
    }

    public void setPayRate(int index, double payRate) {
        this.payRate[index] = payRate;
    }

    public void setWages(int index) {
        this.wages[index] = getPayRate(index) * getHours(index);
    }

    public int getId(int index) {
        return employeeID[index];
    }

    public int getHours(int index) {
        return hours[index];
    }

    public double getPayRate(int index) {
        return payRate[index];
    }

    public double getWage(int index) {
        return hours[index] * payRate[index];
    }

    public void checkGross(int id) {
        for (int i = 0; i < NUMBER_OF_PEOPLE; i++) {
            if (id == getId(i)) {
                System.out.println("$" + getWage(i));
            } else{
                System.out.println(id + " doesn't exist.");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Payroll employees = new Payroll();

        Scanner input = new Scanner(System.in);

        System.out.println("____________________________________________");
        System.out.print("Enter employee id that you want to check his/her gross pay: ");
        employees.checkGross(input.nextInt());
    }
}
