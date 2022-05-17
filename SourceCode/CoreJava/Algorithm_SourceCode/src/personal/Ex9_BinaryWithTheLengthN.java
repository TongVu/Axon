package personal;

import java.util.Scanner;

public class Ex9_BinaryWithTheLengthN {
    public static void decimalToBinary(int a, int lengthOfBinary) {
        int n = a, i = 2;


        for (int count = 0; count <= lengthOfBinary; count++) {
            if (n < 1) {
                if (count == 0)
                    System.out.print("\b"); // cost me almost an hour to put this line here :'(
                else
                    System.out.print(0);
            } else {
                while (n >= 1) {
                    System.out.print(n % 2);
                    n = n / i;
                    count++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        System.out.print("Enter n: ");
        n = input.nextInt();
        // n is the number of bits
        //1: [0] = 2^0 = 1
        //2: [0][1] = 2^0 + 2^1 = 3
        //3: [0][1][2] = 2^0 + 2^1 + 2^2 = 7
        // those things are the limit of each bits set,
        // so my idea is calculate the limit of the given bits set then convert it to binary code
        // just like the decimalToBinary until we reach the end


        int limit = 0;
        for (int i = 0; i < n; i++) {
            limit += (int) Math.pow(2, i);
        }
        for (int i = 0; i < limit; i++) {
            decimalToBinary(i, n);
            System.out.println();
        }

    }
}
