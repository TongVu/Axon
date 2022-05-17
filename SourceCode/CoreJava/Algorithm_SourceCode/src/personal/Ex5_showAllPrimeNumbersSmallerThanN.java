package personal;

import java.util.Scanner;

public class Ex5_showAllPrimeNumbersSmallerThanN {
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
        int n;
        Scanner input = new Scanner(System.in);

        System.out.println("This program shows all prime numbers which are smaller than n");
        System.out.print("Input n: ");
        n = input.nextInt();

        System.out.println("All prime numbers smaller than n");
        for (int i = 0; i < n; i++) {
            if(isPrime(i))
                System.out.println(i);
        }
    }
}
