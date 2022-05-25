package com.axonactive.firstNumber;

import java.util.Scanner;

public class findFirstNumberOfN {
    public static int firstNumbOfN(int n){
        if(n < 10) return n;
        n /= 10;
        return firstNumbOfN(n);
    }

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter n: ");
        n = input.nextInt();

        System.out.println(firstNumbOfN(n));
    }
}
