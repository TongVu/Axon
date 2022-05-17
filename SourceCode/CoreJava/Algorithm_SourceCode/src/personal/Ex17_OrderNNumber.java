package personal;

import java.util.Scanner;

public class Ex17_OrderNNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        System.out.print("n: ");
        n = input.nextInt();

        int count = 0,
                tmp = n;
        while (tmp > 0) {
            tmp /= 10;
            count++;
        }

        int[] arr = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            if (n < 1) arr[i] = n;

            else arr[i] = n % 10;

            n = n / 10;
        }
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++){
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int nu :
                arr) {
            System.out.print(nu + "->");
        }
        System.out.print("\b\b");
    }
}
