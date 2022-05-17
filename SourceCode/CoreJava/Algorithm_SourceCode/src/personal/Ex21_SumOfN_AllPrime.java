package personal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex21_SumOfN_AllPrime {
    public static void primeRefactor(long n) {
        {
            while (n % 2 == 0) {
                System.out.print(2 + " * ");
                n /= 2;
            }

            for (int i = 3; i <= Math.sqrt(n); i += 2) {
                while (n % i == 0) {
                    System.out.print(i + " * ");
                    n /= i;
                }
            }

            if (n > 2)
                System.out.print(n);
        }
    }

    public static void sumAllNumbersInAString(String strNumber){
        List<Character> numbersAsChar = new ArrayList<>();
        for (int i = 0; i < strNumber.length(); i++) {
            numbersAsChar.add(strNumber.charAt(i));
        }

        int sum = 0;
        for (int i = 0; i < numbersAsChar.size(); i++) {
            sum = sum + Integer.parseInt(numbersAsChar.get(i).toString());
        }

        System.out.println("SUM :" + sum);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n;

        // 1. Input a positive n
        System.out.println(
                "This program ask usr to input n. Then show sum from 1 to n." +
        " Then show all the prime divisors of n.");
        System.out.print("Enter n: ");
        n = input.nextLong();

        //2. sum all number in n
        String strNumber = Long.toString(n);
        sumAllNumbersInAString(strNumber);

        //3. refactoring the number
        primeRefactor(n);
    }
}
