package personal;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex22 {
    public static List showDividers(int n){
        List<Integer> dividers = new ArrayList<>();
        dividers.add(1);

        System.out.println("All dividers: ");

        for (int i = 2; i < n; i++) {
            if(n % i == 0){
                System.out.print(i + "->");
                dividers.add(i);
            }
        }
        System.out.print("\b\b");
        System.out.println();

        return dividers;
    }

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

    public static void showPrimeNumbers(List<Integer> listNumbers){
        for (int number :
                listNumbers) {
            if(isPrime(number)) System.out.println(number);
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        System.out.println("Enter number n: ");
        n = input.nextInt();

        List<Integer> arr = showDividers(n);
        System.out.println("Prime number in dividers: ");
        showPrimeNumbers(arr);

    }
}
