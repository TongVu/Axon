package com.axonactive.problem9;

import java.util.Scanner;

/*
    S = 1 -2 + 3 - 4 + ...+ ((-1)^(n+1)).n
 */
public class findS {
    public static int findS(int n){
        if(n == 1) return 1;

        int current =(int) Math.pow(-1, n+1)*n;
        return current + findS(n-1);

    }

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter n: ");
        n = input.nextInt();

        System.out.println(findS(n));
    }
}
