package com.axonactive.programmingChallenges;

import java.sql.SQLOutput;

public class DateManagementDemo {
    public static void main(String[] args) {
//        System.out.println("\n\nTEST AFTER =========================");
//        MyDate md = new MyDate("31", "12", "2017");
//        MyDate md2 = new MyDate("21", "03", "2020");
//        MyDate md3 = new MyDate("01", "08", "2017");
//        MyDate md4 = new MyDate("31", "12", "2020");
//        MyDate md5 = new MyDate("05", "05", "1996");
//
//        System.out.println(md.afterOneDay());
//        System.out.println(md2.afterOneDay());
//        System.out.println(md3.afterOneDay());
//        System.out.println(md4.afterOneDay());
//        System.out.println(md5.afterOneDay());

//        System.out.println("\n\nTEST BEFORE =========================");
//        MyDate md6= new MyDate("28", "02", "2017");
//        MyDate md7 = new MyDate("29", "02", "2020");
//        MyDate md8 = new MyDate("01", "02", "1996");
//        MyDate md9 = new MyDate("31", "12", "2020");
        MyDate md10 = new MyDate("30", "04", "2022");

//        System.out.println(md10.afterOneDay());

//        System.out.println(md6.beforeOneDay());
//        System.out.println(md7.beforeOneDay());
//        System.out.println(md8.beforeOneDay());
//        System.out.println(md9.beforeOneDay());
//        System.out.println(md10.beforeOneDay());



//        System.out.println("\n\nTEST EQUALS =========================");
//        System.out.print("md10 date: ");
//        md10.showDate();
//
//        MyDate checkEqualDate = new MyDate("30", "04", "2022");
//        System.out.println("Is check date equal the md10 date: " +
//                md10.equals(checkEqualDate));
//        MyDate checkEqualDateExpectedFalse = new MyDate("30", "02", "2022");
//        System.out.println("Is check date equal the md10 date: " +
//                md10.equals(checkEqualDateExpectedFalse));
//

//        System.out.println("\n\nTEST INCREASE =========================");
//        System.out.println(md10.increaseDays(33));

        System.out.println("\n\nTEST DECREASE =========================");
        MyDate dateTestDecreased = new MyDate("12", "01", "2022");
        System.out.println(dateTestDecreased.decreaseDays(365));

    }
}
