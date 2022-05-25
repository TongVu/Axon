package com.axonactive.reverseNumber;

import java.util.Scanner;

public class reverseNumber {
    public static void reverse(int n) {
        if (n < 10)
            System.out.print(n);
        else {
            System.out.print(n % 10);
            n /= 10;
            reverse(n);
        }

    }

    public static void main(String[] args) {
        int n;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter n:");
        n = input.nextInt();

        reverse(n);

    }
}
