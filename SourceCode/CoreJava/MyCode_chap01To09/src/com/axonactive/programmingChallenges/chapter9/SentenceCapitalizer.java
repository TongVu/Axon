package com.axonactive.programmingChallenges.chapter9;

import java.util.Scanner;

public class SentenceCapitalizer {
    // This methods split the string and capitalizes every first character that comes after the dot.
    public static String[] capitalilzeTokens(String str) {
        String[] tokens = str.split(" ");

        // First character of the First token always uppercase.
        tokens[0] = tokens[0].substring(0, 1).toUpperCase() + tokens[0].substring(1);

        // If the previous token doesn't end with "."
        // then the current token doesn't have to be capitalized the first character
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i - 1].endsWith(".")) {
                tokens[i] = tokens[i].substring(0, 1).toUpperCase() + tokens[i].substring(1);
            }
        }

        return tokens;
    }

    public static StringBuilder toUppercaseEveryFirstChar(String[] tokensList){
        StringBuilder newStr = new StringBuilder();

        for (String token: tokensList) {
            newStr.append(token).append(" ");
        }

        return newStr;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String strInput;
        StringBuilder newStr;

        System.out.print("Enter a string: ");
        strInput = input.nextLine();

        newStr = toUppercaseEveryFirstChar( capitalilzeTokens(strInput));
        System.out.println("This is the new string: " + newStr);
    }
}
