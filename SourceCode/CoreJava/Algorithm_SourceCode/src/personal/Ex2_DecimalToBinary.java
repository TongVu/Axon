package personal;

import java.util.Scanner;

public class Ex2_DecimalToBinary {
    public static void decimalToBinary(int a) {
        int n = a, i = 2;

        if (n == 0) {
            System.out.println(0);
        } else
            while (n >= 1) {
                System.out.print(n % 2);
                n = n / i;
            }
    }

    public static void main(String[] args) {
        int numb;
        Scanner input = new Scanner(System.in);

        System.out.print("Number: ");
        numb = input.nextInt();

        decimalToBinary(numb);
    }
}
