package personal;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex20_FibonacciPrime {
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

        System.out.println("This program show all the prime Fibonacci number smaller than a given n");
        System.out.print("Enter n: ");
        n = input.nextInt();

        ArrayList<Integer> nFibonacci = new ArrayList<>();

        int prev = 1,
                current = 1,
                fibonacci = 0;

       while (fibonacci < n) {
           fibonacci = prev + current;
           nFibonacci.add(fibonacci);
           prev = current;
           current = fibonacci;
       }


        for (int fi :
                nFibonacci) {
            if(isPrime(fi) && fi < n) System.out.print(fi + "->");
        }
        System.out.print("\b\b");
    }
}


