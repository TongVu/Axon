package personal;

import java.util.Scanner;

public class Ex39_SquareMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cells;

        System.out.print("Enter cell for matrix: ");
        cells = input.nextInt();

        int[][] matrix = new int[cells][cells];
        for (int i = 0; i < cells; i++) {
            for (int j = 0; j < cells; j++) {
                System.out.print("Enter element: ");
                matrix[i][j] = input.nextInt();
                input.nextLine();
            }
        }
        for (int[] row :
                matrix) {
            for (int element :
                    row) {
                System.out.print(element + " ==== ");
            }
            System.out.println();
        }

        int max = 0, sum = 0;

        // find horizontal max
        for (int i = 0; i < cells; i++) {
            for (int j = 0; j < cells; j++) {
                sum += matrix[i][j];
            }
//            System.out.println(sum);
            if (max < sum) max = sum;
            sum = 0;
        }

        // find vertical max
        sum = 0;
        for (int i = 0; i < cells; i++) {
            for (int j = 0; j < cells; j++) {
                sum += matrix[j][i];
            }
//            System.out.println(sum);
            if (max < sum) max = sum;
            sum = 0;
        }

        sum = 0;
        // find diagonal max from left to right
        for (int i = 0; i < cells; i++) {
            sum += matrix[i][i];
        }
//        System.out.println(sum);
        if (max < sum) max = sum;
        sum = 0;

        // find diagonal max from right to left
        for (int i = 0; i < cells; i++) {
            sum += matrix[i][(cells-1)-i];

        }
//        System.out.println(sum);
        if (max < sum) max = sum;

        System.out.println("Max sum: " + max);


        // find transpose of matrix
        int[][] transpose = new int[cells][cells];
        for (int i = 0; i < cells; i++) {
            for (int j = 0; j < cells; j++) {
                transpose[i][j] = matrix[j][i];
            }
        }

        for (int[] row :
                transpose) {
            for (int element :
                    row) {
                System.out.print(element + " ==== ");
            }
            System.out.println();
        }

    }
}
