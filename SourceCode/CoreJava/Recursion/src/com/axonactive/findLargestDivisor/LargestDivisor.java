package com.axonactive.findLargestDivisor;

import java.util.Scanner;

public class LargestDivisor {
    public static int findLargestDivisor(int x, int y) {
        if (x == y) return x;

        if (x > y) return findLargestDivisor(y, x - y);

        return findLargestDivisor(x, y-x);
    }

    public static void main(String[] args) {
        int x,y;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter x: ");
        x = input.nextInt();

        System.out.print("Enter y: ");
        y= input.nextInt();

        System.out.print(findLargestDivisor(x,y));
    }
}
