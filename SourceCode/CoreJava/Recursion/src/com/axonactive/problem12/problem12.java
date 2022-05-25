package com.axonactive.problem12;

import java.util.Scanner;

// p = x ^ y
public class problem12 {
    public static int power(int x, int y){
        if(y == 0) return 1;

        return x * power(x, y - 1);
    }

    public static void main(String[] args) {
        int x,y;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter x: ");
        x = input.nextInt();

        System.out.print("Enter y: ");
        y = input.nextInt();

        System.out.println(power(x,y));
    }
}
