package personal;

import java.util.Scanner;

public class Ex7_Fibonaci_Nth {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        System.out.print("To find the nth fibonaci. \nEnter n: ");
        n = input.nextInt();

        int prev = 1,
                current = 1,
                fibonacci = 0;
        if (n == 1) System.out.println(1);
        if (n == 2) System.out.println(1);

        else
            for (int i = 3; i <= n; i++) {
                fibonacci = prev + current;
                prev = current;
                current = fibonacci;
            }
        System.out.println("Fibonaci: " + current);
    }
}
