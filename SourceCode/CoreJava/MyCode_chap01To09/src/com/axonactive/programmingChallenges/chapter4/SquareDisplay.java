package com.axonactive.programmingChallenges.chapter4;
import java.util.Scanner;

public class SquareDisplay {
    public static void main(String[] args) {
        int usrNum;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number <= 15: ");
        usrNum = input.nextInt();

        for(int line = 0; line < usrNum; line++){
            for(int charPerRow = 0; charPerRow < usrNum; charPerRow++){
                System.out.print("X");
            }
            System.out.print("\n"); // Go to next line after print the characters in a row
        }
    }
}
