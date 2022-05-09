package com.axonactive.programmingChallenges.chapter4;
import java.util.Scanner;

public class LetterCounter {
    public static void main(String[] args) {
        String strFromUsr;
        char charFromUsr;
        int flag = 0;
        Scanner input = new Scanner(System.in);

        System.out.print("Please input a string: ");
        strFromUsr = input.nextLine();

        System.out.print("Please enter a char: ");
        charFromUsr = input.next().charAt(0);

        for(int count = 0; count < strFromUsr.length(); count++){
            if( charFromUsr == strFromUsr.charAt(count)){
                flag++;
            }
        }

        System.out.println("The number of times the " + charFromUsr + " appeared in the String is: " + flag);
    }
}
