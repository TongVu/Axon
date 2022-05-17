package com.axonactive.programmingChallenges.problem3;

public class printAsterisk {
    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(i == 4){
                    System.out.print("*");
                } else {
                    if (j == i ||
                            9 - i - 1 == j) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
