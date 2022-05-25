package com.axonactive.countNumber;

import java.util.Scanner;

public class countNumber {
    public static int countNumber(int n, int count) {
        if (n / 10 == 0) {
            count++;
            return count;
        }

        n /= 10;
        count++;

        return countNumber(n, count);
    }

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter n: ");
        n = input.nextInt();
        System.out.println("Total numbers in n: " + countNumber(n, 0));

    }
}
