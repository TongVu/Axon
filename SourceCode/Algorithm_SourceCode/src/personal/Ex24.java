package personal;

import java.util.Scanner;

public class Ex24 {
    public static void findMax(int[][] arr) {
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max < arr[i][j]) max = arr[i][j];
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

    public static void showPrimes(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(isPrime(arr[i][j])) System.out.print(arr[i][j] + " ->");
                else System.out.print(0 + " ->");
            }
            System.out.print("\b\b");
            System.out.println();
        }

    }

    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        for (int number :
                arr) {
            System.out.print(number + " -> ");
        }
        System.out.print("\b\b\b");
    }

    public static void sortColumns(int[][] arr){
        int rows = arr.length;

        for (int i = 0; i < arr.length; i++) {
            sort(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rows, columns;

        System.out.print("Enter rows: ");
        rows = input.nextInt();

        System.out.print("Enter columns: ");
        columns = input.nextInt();

        int[][] matrix = new int[rows][columns];
        int val = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                do {
                    if (val > 100) System.out.println("Value for matrix in range 0 - 100");
                    System.out.print("Enter values for [" + i + "]" +
                            "[" + j + "]: "
                    );
                    val = input.nextInt();
                    matrix[i][j] = val;
                } while (val > 100);
            }
        }

/*
        PRINT ARRAY

        System.out.println("The Matrix");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println("[" + i + "][" + j + "]: " + matrix[i][j]);
            }
        }
*/

        // Find max
        findMax(matrix);

        // Show prime
        System.out.println("Prime numbers in matrix");
        showPrimes(matrix);

        // Sort columns
        sortColumns(matrix);
    }
}
