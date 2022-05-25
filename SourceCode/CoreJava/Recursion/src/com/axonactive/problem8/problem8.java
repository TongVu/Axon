package com.axonactive.problem8;

import java.util.Scanner;

public class problem8 {
    public static int findS(int n, int start){
        if(n == 0) return 1;
        if(start == 2*n + 1) return start;

        return start + findS(n, start + 2);
    }

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter n: ");
        n = input.nextInt();

        System.out.println(findS(n, 1));
    }
}
