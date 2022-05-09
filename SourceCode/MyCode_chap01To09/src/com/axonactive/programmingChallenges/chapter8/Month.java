package com.axonactive.programmingChallenges.chapter8;

public class Month {
    int monthNumber;

    public Month() {
        monthNumber = 1;
    }

    public Month(int monthNumber) {
        if (monthNumber < 1 || monthNumber > 12)
            this.monthNumber = 1;
        else
            this.monthNumber = monthNumber;
    }

    public Month(String monthName) {

        switch (monthName) {
            case "December":
                monthName = "12";
                break;
            case "November":
                monthName = "11";
                break;
            case "October":
                monthName = "10";
                break;
            case "September":
                monthName = "9";
                break;
            case "August":
                monthName = "8";
                break;
            case "July":
                monthName = "7";
                break;
            case "June":
                monthName = "6";
                break;
            case "May":
                monthName = "5";
                break;
            case "April":
                monthName = "4";
                break;
            case "March":
                monthName = "3";
                break;
            case "February":
                monthName = "2";
                break;
            default:
                monthName = "1";
        }
    }

    public void setMonthNumber(int monthNumber) {
        if (monthNumber < 1 || monthNumber > 12)
            this.monthNumber = 1;
        else
            this.monthNumber = monthNumber;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public String getMonthName(){
        switch (monthNumber) {
            case 12:
                return "December";
            case 11:
                return "November";
            case 10:
                return "October";
            case 9:
                return "September";
            case 8:
                return "August";
            case 7:
                return "June";
            case 6:
                return "July";
            case 5:
                return "May";
            case 4:
                return "April";
            case 3:
                return "March";
            case 2:
                return "February";
            default:
                return  "January";
        }
    }

    public String toString(){
        return getMonthName();
    }

    public boolean equals(Month m){
        return this.monthNumber == m.monthNumber;
    }

    public boolean greaterThan(Month m){
        return this.monthNumber < m.monthNumber ;
    }

    public boolean lessThan(Month m){
        return this.monthNumber > m.monthNumber ;
    }

    public static void main(String[] args) {
        Month[] months = new Month[3];

        months[0]= new Month(-3);
        months[1]= new Month(15);
        months[2] = new Month(8);

        for (int i = 0; i < months.length; i++) {
            System.out.println(months[i].getMonthNumber() + " - " + months[i].getMonthName());
        }

        System.out.println("Is month 3 greater than month 1? " + months[2].greaterThan(months[0]));
        System.out.println("Is month 2 less than month 3? " + months[1].greaterThan(months[2]));

    }
}


