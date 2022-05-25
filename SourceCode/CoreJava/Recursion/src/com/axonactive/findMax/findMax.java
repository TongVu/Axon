package com.axonactive.findMax;

import java.util.Scanner;

public class findMax {
    public static int findMax(int n, int max){
        if(n < 10){
            return n < max ? max : n;
        }

        //compare max with each number in the input number
        if(( n % 10 ) > max){
            max = n % 10;
        }
        n /= 10;
        return (findMax(n, max));
    }

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter n: ");
        n = input.nextInt();
        System.out.print("Max: " + findMax(n, 0));

    }
}
