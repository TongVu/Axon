package com.axonactive.programmingChallenges.chapter6;

import java.util.Scanner;

public class MonthDays {
    private int month;
    private int year;

    public MonthDays(int monthIn, int yearIn) {
        month = monthIn;
        year = yearIn;
    }

    public int numberOfDays() {
        int day = 0;
        boolean isLeapYear = false;
        //Identify leap year
        if ((year % 100 == 0 && year % 400 == 0) ||
                (year % 4 == 0)) {
            isLeapYear = true;
        }
        if (isLeapYear) {
            switch (month) {
                case 2:
                case 4:
                case 6:
                case 9:
                case 11:
                    day = 29;
                    break;
                default:
                    day = 31;
            }
        } else {
            switch (month) {
                case 2:
                    day = 28;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    day = 30;
                default:
                    day = 31;
            }
        }
        return day;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int month = 0, year = 0;

        do {
            System.out.print("Enter the month: ");
            month = input.nextInt();
        } while (month < 1 || month > 12);

        System.out.print("Enter the year: ");
        year = input.nextInt();

        MonthDays dayInAMonth = new MonthDays(month, year);
        System.out.println(dayInAMonth.numberOfDays() + " days");

    }
}
