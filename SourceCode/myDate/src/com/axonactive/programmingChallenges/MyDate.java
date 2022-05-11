package com.axonactive.programmingChallenges;

import java.util.Scanner;
import java.util.StringTokenizer;

public class MyDate {
    private String day;
    private String month;
    private String year;
    private String date;

    public MyDate() {
    }

    ;

    public static boolean isNumber(String dateMonthOrYear) {
        if (dateMonthOrYear == null) return false;

        try {
            Integer.parseInt(dateMonthOrYear);
        } catch (NumberFormatException numberFormatException) {
            return false;
        }

        return true;
    }

    public boolean isDayFromOneToThirtyOne() {
        if (Integer.parseInt(day) > 0 &&
                Integer.parseInt(day) <= 31) {
            return true;
        } else return false;
    }

    public boolean isMonthFromOneToTwelve() {
        if (Integer.parseInt(month) > 0 &&
                Integer.parseInt(month) < 13) {
            return true;
        } else return false;
    }

    public String inputDay() {
        Scanner input = new Scanner(System.in);

        System.out.println("Format: dd / mm / yyyy");
        System.out.print("Enter a day: ");
        this.day = input.nextLine();

        System.out.print("Enter a month: ");
        this.month = input.nextLine();

        System.out.print("Enter a year (year have to be from 0): ");
        this.year = input.nextLine();

        this.date = this.day + "/" + this.month + "/" + this.year;
        return this.date;
    }

    public boolean isDayMonthAndYearAllNumber() {
        return isNumber(day) && isNumber(month) && isNumber(year);
    }

    public boolean isLeapYear() {
        int yearCheck = Integer.parseInt(this.year);

        if (yearCheck % 4 != 0) {
            return false;
        } else if (yearCheck % 400 == 0) {
            return true;
        } else if (yearCheck % 100 == 0) {
            return false;
        } else return true;
    }

    public boolean validDate() {
        if (!isDayMonthAndYearAllNumber()) return false;

        if (!isDayFromOneToThirtyOne()) return false;

        if (!isMonthFromOneToTwelve()) return false;

        if (Integer.parseInt(year) < 0) return false;

        if (Integer.parseInt(month) == 2) {
            if (isLeapYear()) {
                if (Integer.parseInt(day) > 29) return false;
            } else if (Integer.parseInt(day) > 28) return false;
        }
        return true;
    }

    /*
        Months have 31 days: 01, 03, 05, 07, 08, 10, 12
        Months have 30 days: 04, 06, 09, 11
        February have 28 days (29 days if leap year)
     */

    public String afterOneDay(){
        int monthNumber = Integer.parseInt(month);
        int dayNumber = Integer.parseInt(day);

        if(dayNumber == 30 &&
                monthNumber == 1 ||
                monthNumber == 3 ||
                monthNumber == 5 ||
                monthNumber == 7 ||
                monthNumber == 8 ||
                monthNumber == 10||
                monthNumber == 12){
            day = "00";
            if(monthNumber == 12){
                month = "01";
            } else{
                monthNumber++;
                month = Integer.toString(monthNumber);
            }
        }

        return date;
    }
}
