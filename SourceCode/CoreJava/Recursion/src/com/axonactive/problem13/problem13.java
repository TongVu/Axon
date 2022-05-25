package com.axonactive.problem13;

import java.util.Scanner;

// S = 1 + 1/2 + 1/3 + ... + 1/n
public class problem13 {
    public static double findS(int n) {
        if (n == 1) return 1;

        return (1.0 / n) + findS(n - 1);
    }

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter n: ");
        n = input.nextInt();

        System.out.println(findS(n));
    }
}
