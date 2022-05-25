package com.axonactive.problem10;

import java.util.Scanner;

// S = 1 + 1.2 + 1.2.3 + 1.2.3.4 + ... 1.2.3.4..n
// n > 0
public class problem10 {
    public static int factorial(int n) {
        if (n == 0) return 1;

        return n * factorial(n - 1);
    }

    public static int findS(int n) {
        if(n == 1) return 1;

        int currentFactorial = factorial(n);

        return findS(n-1) + currentFactorial;
    }

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter n: ");
        n = input.nextInt();

        System.out.println(findS(n));
    }
}
