package personal;

import java.util.Scanner;

public class Ex10_showAllSubsets {
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);

        System.out.println("This program show all subsets of n");
        System.out.print("Enter n: ");
        n = input.nextInt();

        int subsetOf = 1;
        while (subsetOf < n) {
            int number = 0;
            for (int i = 1; i < n; i++) {
                if(number < n){
                    System.out.print("{ ");
                    for (int j = 0; j < subsetOf; j++) {
                        for (int k = j+1; k < n ; k++) {
                            if(number < n){
                                System.out.print(number + " ");
                                number++;
                            }
                        }
                    }
                    System.out.print("}\n");
                }
            }
            subsetOf++;
        }
    }
}
