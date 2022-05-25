package com.axonactive.checkEvenOdd;

import java.util.Scanner;

public class CheckEvenOdd {
    public static boolean isEven(int n){
        if(n == 1) return false;
        else if(n == 0) return true;

        return isEven(n - 2);
    }

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter n: ");
        n = input.nextInt();

        System.out.println(n + " : " + isEven(n));
    }
}
