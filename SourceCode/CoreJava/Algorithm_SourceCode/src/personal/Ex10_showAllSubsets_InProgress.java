package personal;

import java.util.Scanner;

public class Ex10_showAllSubsets_InProgress {
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);

        System.out.println("This program show all subsets of n");
        System.out.print("Enter n: ");
        n = input.nextInt();

        int[] largestSubset = new int[n];
        int[] helper = new int[n];

        for (int i = 0; i < n; i++) {
            largestSubset[i] = i + 1;
            helper[i] = i + 1;
        }

        for (int i = 0; i < n; i++) {
            System.out.print("{ ");
            System.out.print(largestSubset[i] + " ");

            for (int j = i + 1; j < n; j++) {
                System.out.print(helper[j] + " ");
            }

            System.out.println("}");
        }
    }
    /*
        1
        1 2
        1 3
        1 4
        1 2 3
        1 3 4
        1 2 3 4

        2
        2 3
        2 4
        2 3 4

        3
        3 4

        4

     */
}
