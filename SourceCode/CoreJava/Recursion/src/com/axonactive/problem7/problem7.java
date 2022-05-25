package com.axonactive.problem7;

import java.util.Scanner;

// p = 1*3*5..(2n+1) n > 0 = 0
public class problem7 {
    public static int findP(int n, int start){
        if(n == 0) return 1;
        if(start == 2*n+1) return start;

        return start * findP(n, start + 2);
    }

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter n: ");
        n = input.nextInt();

        System.out.println(findP(n, 1));
    }
}
