package com.axonactive.programmingChallenges.chapter4;
import java.util.Scanner;

// 5 stores

public class BarChart {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int store1, store2, store3, store4, store5;

        System.out.print("Input today's sales for store 1: ");
        store1 = input.nextInt();

        System.out.print("Input today's sales for store 2: ");
        store2 = input.nextInt();

        System.out.print("Input today's sales for store 3: ");
        store3 = input.nextInt();

        System.out.print("Input today's sales for store 4: ");
        store4 = input.nextInt();

        System.out.print("Input today's sales for store 5: ");
        store5 = input.nextInt();


        System.out.println("SALES BAR CHART");

        System.out.print("Store 1: ");
        for (int i = 100; i < store1; i += 100){
            System.out.print("*");
        }

        System.out.print("\nStore 2: ");
        for (int i = 100; i < store2; i += 100){
            System.out.print("*");
        }

        System.out.print("\nStore 3: ");
        for (int i = 100; i < store3; i += 100){
            System.out.print("*");
        }

        System.out.print("\nStore 4: ");
        for (int i = 100; i < store4; i += 100){
            System.out.print("*");
        }

        System.out.print("\nStore 5: ");
        for (int i = 100; i < store5; i += 100){
            System.out.print("*");
        }
    }
}
