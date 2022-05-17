package personal;

import java.util.Scanner;

public class Ex1_GreatestCommonDivisorAndLeastCommonMultiple {

    public static void greatestCommonDivisorAndLeastCommonMultiple(int a, int b){
        int min = a < b ? a : b;
        int divisor = 1;

        for (int i = 1; i <= min; i++) {
            if(min == 1) break;
            else if(a % i == 0 && b % i == 0){
                divisor = i;
            }
        }

        int minCommonMultiple = (a * b) / divisor;

        System.out.println("Greatest common divisor: " + divisor);
        System.out.println("Least common mutiple: " + minCommonMultiple);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a, b;
        System.out.print("a: ");
        a = input.nextInt();

        System.out.print("b: ");
        b = input.nextInt();

        greatestCommonDivisorAndLeastCommonMultiple(a, b);
    }
}
