package personal;

import java.util.Scanner;

public class Ex28 {
    public static void findMax(int[][] arr) {
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max < arr[i][j])
                    max = arr[i][j];
            }
        }

        System.out.println("MAX: " + max);
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

    public static void showPrime(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(!isPrime(arr[i][j])) arr[i][j] = 0;
            }
        }

        for (int[] row :
                arr) {
            for (int number :
                    row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    public static void findRowHasMostPrimeNumbs(int[][] arr){
        int mostPrime = 0;

        for (int[] row : arr) {
            int currentPrime = 0;
            for (int number : row) {
                if (number != 0) {
                    ++currentPrime;
                    if(currentPrime > mostPrime) mostPrime = currentPrime;
                }
            }
        }

        System.out.println("Most prime numbers in a row: " + mostPrime);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int val = 0;

//        int ROWS = 5,
//                COLUMNS = 3;
//        int[][] matrix = new int[ROWS][COLUMNS];

//        for (int i = 0; i < ROWS; i++) {
//            for (int j = 0; j < COLUMNS; j++) {
//                System.out.print("Input val: ");
//                matrix[i][j] = input.nextInt();
//            }
//        }

        int[][] matrix = {
                {5,   6,  9, 15, 30, 22},
                {80, 43, 31, 97, 88, 70},
                {3,   7,  8, 25, 31, 33},
                {12, 18, 26, 18, 30, 31},
                {99, 97, 65, 17, 19, 29}
        };
     findMax(matrix);
     showPrime(matrix);
     findRowHasMostPrimeNumbs(matrix);
    }
}
