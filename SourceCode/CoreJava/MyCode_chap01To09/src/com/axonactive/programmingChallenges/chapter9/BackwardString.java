package com.axonactive.programmingChallenges.chapter9;

import java.util.Scanner;

public class BackwardString {
    public static StringBuilder reverseStr(String str){
        StringBuilder reverseString = new StringBuilder("");

        for (int i = ( str.length() - 1); i >= 0 ; i--) {
            reverseString.append(str.charAt(i));
        }
        return reverseString;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String usrInput;
        System.out.print("Please enter a string: ");
        usrInput = input.nextLine();

        System.out.println("Reserse of " + usrInput);
        System.out.println(reverseStr(usrInput));
    }
}
