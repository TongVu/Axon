package com.axonactive.programmingChallenges.chapter9;

import java.util.Scanner;

public class WordCounter {
    public static int countWord(String str, String searchValue) {
        String[] tokens = str.split(searchValue);

        return tokens.length;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String strInput;

        System.out.print("Enter a string: " );
        strInput = input.nextLine();
        System.out.println("In the string \"" + strInput + "\" have "
                + countWord(strInput, " ")
                + " words");
    }
}
