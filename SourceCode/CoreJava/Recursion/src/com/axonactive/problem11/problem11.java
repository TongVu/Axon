package com.axonactive.problem11;

import java.util.Scanner;

// S = 1^2 + 2^2 + 3^2 + 4^2 + ... + n^2
public class problem11 {
    public static int findS(int n){
        if(n == 1) return 1;

        int current = (int) Math.pow(n, 2);
        return findS(n - 1) + current;
    }

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter n: ");
        n = input.nextInt();

        System.out.println(findS(n));

    }
}
