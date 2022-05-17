package personal;

import java.util.Scanner;

public class Ex6_ShowPrimeNumbs {
    public static void showPrimeNumbs(int n){
        for(int i = 1; i < n; i++){
            if(isPrime(i)){
                System.out.print(i + " ");
            }
        }

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

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        System.out.print("n: ");
        n = input.nextInt();
        showPrimeNumbs(n);
    }
}
