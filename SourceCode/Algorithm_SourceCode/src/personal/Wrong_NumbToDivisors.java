package personal;

import java.util.Scanner;

/**
 * Wrong
 */

public class Wrong_NumbToDivisors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a;

        System.out.print("a: ");
        a = input.nextInt();

        System.out.print(a + " = ");

        int i = 2;
        while (a / i >= 1) {
            if (a % i == 0) {
                System.out.print(i + " * ");
                a = a / i;
                i = 2;
            }
            i++;
        }
        System.out.print("\b\b");
    }
}
