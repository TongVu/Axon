package com.axonactive.programmingChallenges.Challenges;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PrimeNumberList {
    public static boolean isPrime(int n){
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        System.out.println("The program shows all the prime numbers smaller than n");
        System.out.print("Enter n number: ");
        n = input.nextInt();

        List<Integer> primeNumbs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(isPrime(i)) primeNumbs.add(i);
        }

        Iterator<Integer> it = primeNumbs.listIterator();
        while(it.hasNext())
            System.out.println(it.next() + " ");

    }
}
