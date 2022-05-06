package personal;

import java.util.Scanner;

public class Ex4_ShowPrimeFactor {
    public static void primeRefactor(int n) {
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


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        System.out.print("Enter n: ");
        n = input.nextInt();
        primeRefactor(n);
    }
}
