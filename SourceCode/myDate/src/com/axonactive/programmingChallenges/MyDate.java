package com.axonactive.programmingChallenges;

import java.util.Scanner;
import java.util.StringTokenizer;

public class MyDate {
    private String day;
    private String month;
    private String year;

    private String date;

    private boolean isDayMonthAndYearAllNumber() {
        return isNumber(day) && isNumber(month) && isNumber(year);
    }

    private boolean isLeapYear() {
        int yearCheck = Integer.parseInt(this.year);

        if (yearCheck % 4 != 0) {
            return false;
        } else if (yearCheck % 400 == 0) {
            return true;
        } else if (yearCheck % 100 == 0) {
            return false;
        } else return true;
    }

    private boolean isYearGreaterThanZero() {
        return Integer.parseInt(year) < 0;
    }

    private boolean isYearALeapYearAndDayDayFromOneToTwentyNine() {
        if (Integer.parseInt(month) == 2) {
            if (isLeapYear()) {
                if (Integer.parseInt(day) > 29) return false;
            } else if (Integer.parseInt(day) > 28) return false;
        }

        return true;
    }

    private boolean isMonthInMonthsHaveThirtyOneDay() {
        int monthToCheck = Integer.parseInt(month);
        if (monthToCheck == 1 ||
                monthToCheck == 3 ||
                monthToCheck == 5 ||
                monthToCheck == 7 ||
                monthToCheck == 8 ||
                monthToCheck == 10 ||
                monthToCheck == 12) {
            return true;
        }

        return false;
    }

    private boolean isMonthInMonthsHaveThirtyDay() {
        int monthToCheck = Integer.parseInt(month);
        if (monthToCheck == 4 ||
                monthToCheck == 6 ||
                monthToCheck == 9 ||
                monthToCheck == 11) {
            return true;
        }

        return false;
    }

    private String nextMonth() {
        int monthInNumber = Integer.parseInt(month);
        return switch (monthInNumber) {
            case 1 -> "02";
            case 2 -> "03";
            case 3 -> "04";
            case 4 -> "05";
            case 5 -> "06";
            case 6 -> "07";
            case 7 -> "08";
            case 8 -> "09";
            case 9 -> "10";
            case 10 -> "11";
            case 11 -> "12";
            case 12 -> "01";
            default -> "";
        };
    }

    private String nextYear() {
        int yearInNumber = Integer.parseInt(year);
        yearInNumber++;
        return String.valueOf(yearInNumber);
    }

    private String previvousMonth() {
        int monthInNumber = Integer.parseInt(month);
        return switch (monthInNumber) {
            case 1 -> "12";
            case 2 -> "01";
            case 3 -> "02";
            case 4 -> "03";
            case 5 -> "04";
            case 6 -> "05";
            case 7 -> "06";
            case 8 -> "07";
            case 9 -> "08";
            case 10 -> "09";
            case 11 -> "10";
            case 12 -> "11";
            default -> "";
        };
    }

    private String previousYear() {
        int yearInNumber = Integer.parseInt(year);

        if (yearInNumber != 0) yearInNumber--;

        return String.valueOf(yearInNumber);
    }


    public MyDate() {

    }

    public MyDate(String day, String month, String year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public MyDate(String dateInput) {
        this.date = dateInput;
    }

    public MyDate(MyDate newObj) {
        this.date = newObj.getDate();
    }

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

    public String getDate() {
        return date;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
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

    public boolean validDate() {
        if (!isDayMonthAndYearAllNumber()) return false;

        if (!isDayFromOneToThirtyOne()) return false;

        if (!isMonthFromOneToTwelve()) return false;

        if (!isYearGreaterThanZero()) return false;

        if (!isYearALeapYearAndDayDayFromOneToTwentyNine()) return false;

        return true;
    }

    public String afterOneDay() {
        int monthNumber = Integer.parseInt(month);
        int dayNumber = Integer.parseInt(day);
        String dayToShow = day,
                monthToShow = month,
                yearToShow = year;

        if (isMonthInMonthsHaveThirtyOneDay() &&
                dayNumber == 31) {
            dayToShow = "01";
            monthToShow = nextMonth();
            if (monthNumber == 12) yearToShow = nextYear();
        }

        if (isMonthInMonthsHaveThirtyOneDay() &&
                dayNumber != 31) {
            dayNumber++;

            if (dayNumber < 10) dayToShow = "0" + String.valueOf(dayNumber);
            else dayToShow = String.valueOf(dayNumber);
        }

        if (isMonthInMonthsHaveThirtyDay() && dayNumber == 30) {
            dayToShow = "01";
            monthToShow = nextMonth();
        }

        if (isMonthInMonthsHaveThirtyDay()
                && dayNumber != 30) {
            dayNumber++;
            if (dayNumber < 10) dayToShow = "0" + dayNumber;
            else dayToShow = String.valueOf(dayNumber);
        }

        if (isLeapYear() &&
                monthNumber == 2 &&
                dayNumber == 29) {
            dayToShow = "01";
            monthToShow = nextMonth();
        } else if (isLeapYear() &&
                monthNumber == 2) {
            dayNumber++;
            if (dayNumber < 10) dayToShow = "0" + dayNumber;
            else dayToShow = String.valueOf(dayNumber);
        }

        if (!isLeapYear() && monthNumber == 2 && dayNumber == 28) {
            dayToShow = "01";
            monthToShow = nextMonth();
        } else if (!isLeapYear() &&
                monthNumber == 2) {
            dayNumber++;
            if (dayNumber < 10) dayToShow = "0" + dayNumber;
            else dayToShow = String.valueOf(dayNumber);
        }

        return dayToShow + "/" +
                monthToShow + "/" +
                yearToShow;

    }

    public String beforeOneDay() {
        int monthNumber = Integer.parseInt(month);
        int dayNumber = Integer.parseInt(day);

        String dayToShow = day,
                monthToShow = month,
                yearToShow = year;

        if (isMonthInMonthsHaveThirtyDay() &&
                dayNumber == 1) {
            dayToShow = "31";
            monthToShow = previvousMonth();
        }
        if (isMonthInMonthsHaveThirtyDay() &&
                dayNumber != 1) {
            dayNumber--;
            if (dayNumber < 10) {
                dayToShow = "0" + String.valueOf(dayNumber);
            } else dayToShow = String.valueOf(dayNumber);
        }
        if (isMonthInMonthsHaveThirtyOneDay() &&
                dayNumber == 1) {

            dayToShow = "30"; // excepts August, March and January

            if (monthNumber == 8) dayToShow = "31";

            if (monthNumber == 3 && isLeapYear())
                dayToShow = "29";
            else if (monthNumber == 3 &&
                    !isLeapYear())
                dayToShow = "28";

            if (monthNumber == 1) {
                dayToShow = "31";
                yearToShow = previousYear();
            }
            monthToShow = previvousMonth();
        }
        if (isMonthInMonthsHaveThirtyOneDay() &&
                dayNumber != 1) {
            dayNumber--;
            if (dayNumber < 10) {
                dayToShow = "0" + String.valueOf(dayNumber);
            } else dayToShow = String.valueOf(dayNumber);
        }
        if (monthNumber == 2
                && dayNumber == 1) {
            dayToShow = "31";
            monthToShow = previvousMonth();
        }
        if (monthNumber == 2
                && dayNumber != 1) {
            dayNumber--;

            if (dayNumber < 10) {
                dayToShow = "0" + String.valueOf(dayNumber);
            } else dayToShow = String.valueOf(dayNumber);

        }

        return dayToShow + "/" +
                monthToShow + "/" +
                yearToShow;

    }

    public void showDate() {
        String dateToShow = day + "/" +
                month + "/" +
                year;

        System.out.println("Date : " + dateToShow);
    }

    public boolean equals(MyDate dateInput) {
        if (!day.equals(dateInput.getDay())) return false;
        if (!month.equals(dateInput.getMonth())) return false;
        return year.equals(dateInput.getYear());
    }

    private void convertDateToDayMonthYearFormat() {
        StringTokenizer tokens = new StringTokenizer(date, "/");
        this.day = tokens.nextToken();
        this.month = tokens.nextToken();
        this.year = tokens.nextToken();
    }

    public String increaseDays(int numberOfDaysIncreased) {

        for (int i = 0; i < numberOfDaysIncreased; i++) {
            MyDate nextDay = new MyDate(this.afterOneDay());
            this.date = nextDay.getDate();
            convertDateToDayMonthYearFormat();
        }

        return date;
    }

    public String decreaseDays(int numberOfDaysDecreased) {

        for (int i = 0; i < numberOfDaysDecreased; i++) {
            MyDate prevDay = new MyDate(this.beforeOneDay());
            this.date = prevDay.getDate();
            convertDateToDayMonthYearFormat();
        }

        return date;
    }


}
