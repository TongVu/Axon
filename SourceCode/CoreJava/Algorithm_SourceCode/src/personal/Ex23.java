package personal;

import java.util.Scanner;

public class Ex23 {
    public static void showNPrimeNumber(int n){
        int initialValue = 2,
            count = 0;

        while(count < n){
            if(isPrime(initialValue)){
                System.out.println((count + 1 )+": " + initialValue);
                count++;
                initialValue++;
            }
            initialValue++;
        }

    }

    public static void showFirstNFibonacci(int n){
        int prev = 1,
                current = 1,
                fibonacci = 0;
        if (n == 1) System.out.println(1);
        if (n == 2) System.out.println(1);

        else {
            System.out.println(1 + " Fibonacci: " + prev);
            System.out.println(2 + " Fibonacci: " + current);
            for (int i = 3; i <= n; i++) {
                fibonacci = prev + current;
                prev = current;
                current = fibonacci;
                System.out.println(i + " Fibonacci: " + current);
            }
        }
    }

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

        System.out.print("Enter number n: ");
        n = input.nextInt();

        System.out.println("First " + n + " prime numbers: ");
        showNPrimeNumber(n);

        System.out.println("First " + n + " Fibonacci numbers:");
        showFirstNFibonacci(n);
    }
}
