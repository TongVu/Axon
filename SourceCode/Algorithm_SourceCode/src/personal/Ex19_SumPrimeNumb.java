package personal;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex19_SumPrimeNumb {
    public static int sumN(int n){
        int numberLength = 0,
                tmpN = n;

        while (tmpN > 0) {
            tmpN /= 10;
            numberLength++;
        }

        int sum = 0;
        for (int i = 0; i < numberLength; i++) {
            if (n < 1) sum += n;

            else sum += n % 10;

            n = n / 10;
        }

        return sum;
    }

    public static boolean isPrime(int n) {
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
        int s;

        System.out.print("Enter number s: ");
        s = input.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        sumN(10061);

        for (int i = 10000; i < 99999; i++) {
            if (isPrime(i)){
                if(sumN(i) == s) System.out.println(i);
            }
        }

    }
}
