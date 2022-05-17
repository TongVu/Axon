package com.axonactive.programmingChallenges.chapter5;

public class showChar {
    public static char showChar(String str, int position) {
        return str.charAt(position);
    }

    public static void main(String[] args) {
        char letter;
        letter = showChar("Hello", 4);

        System.out.println(letter);
    }
}
