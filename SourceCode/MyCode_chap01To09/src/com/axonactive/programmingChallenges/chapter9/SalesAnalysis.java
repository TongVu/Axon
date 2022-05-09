package com.axonactive.programmingChallenges.chapter9;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalesAnalysis {
    //TODO show the total sales for each week
    public static double[] showWeeklySales(String[] sales) {
        double[] week = {0.0d, 0.0d, 0.0d};

        for (int day = 0; day < 21; day++) {
            if (day < 6) {
                week[0] += Double.parseDouble(sales[day]);
            } else if (day > 6 && day < 13) {
                week[1] += Double.parseDouble(sales[day]);
            } else if (day > 13 && day < 20) {
                week[2] += Double.parseDouble(sales[day]);
            }
        }

        return week;
    }

    //TODO show average daily sales for each week
    public static void averageDailySales(String[] sales) {
        double[] week = showWeeklySales(sales);

        System.out.printf("Week 1: $%.2f\n", week[0] / 7);
        System.out.printf("Week 2: $%.2f\n", week[1] / 7);
        System.out.printf("Week 3: $%.2f\n", week[2] / 7);
    }

    //TODO show total sales for all of the weeks
    public static void showTotalSales(String[] sales){
        double[] totalSales = showWeeklySales(sales);

        System.out.printf("Total sales: $%.2f\n", totalSales[0] + totalSales[1] + totalSales[2]);
    }

    //TODO show the average weekly sales
    public static void averageWeeklySales(String[] sales){
        double[] week = showWeeklySales(sales);

        System.out.printf("Average weekly sales: $%.2f\n" , ( (week[0] + week[1] + week[2]) / 3));
    }

    //TODO show the week had the highest amount of sales
    public static void showHighestWeekSales(String[] sales){
           double[] week = showWeeklySales(sales);
           double max = week[0];

        for (int i = 1; i < week.length; i++) {
            if(week[i-1] < week[i]) max = week[i];
        }
        System.out.printf("Week with highest sales: $%.2f\n", max);
    }

    //TODO show the week had the lowest amount of sales
    public static void showLowestWeekSales(String[] sales){
        double[] week = showWeeklySales(sales);
        double min = week[0];

        for (int i = 1; i < week.length; i++) {
            if(week[i-1] > week[i]) min = week[i];
        }
        System.out.printf("Week with lowest sales: $%.2f\n", min);
    }

    public static void main(String[] args) throws IOException {
        Scanner salesData = new Scanner(new File("SalesData.txt"));
        StringBuilder data = new StringBuilder();

        while (salesData.hasNext()) {
            data.append(salesData.nextLine()).append(',');
        }
        salesData.close();

        String[] dailySales = new String[21]; // 7 days for 3 weeks
        dailySales = data.toString().split(",");

        double[] week = new double[3];
        week[0] = showWeeklySales(dailySales)[0];
        week[1] = showWeeklySales(dailySales)[1];
        week[2] = showWeeklySales(dailySales)[2];
        System.out.println("================ TOTAL SALES EACH WEEK ================");
        System.out.printf("Total sales for week 1 $%.2f\n", week[0]);
        System.out.printf("Total sales for week 2 $%.2f\n", week[1]);
        System.out.printf("Total sales for week 3 $%.2f\n", week[2]);
        showTotalSales(dailySales);

        System.out.println("================ AVG DAILY SALES ================");
        averageDailySales(dailySales);

        System.out.println();
        System.out.println("================ AVG WEEKLY SALES ================");
        averageWeeklySales(dailySales);

        System.out.println();
        System.out.println("================ HIGHEST AND LOWEST WEEKLY SALES ================");
        showHighestWeekSales(dailySales);
        showLowestWeekSales(dailySales);
    }
}
