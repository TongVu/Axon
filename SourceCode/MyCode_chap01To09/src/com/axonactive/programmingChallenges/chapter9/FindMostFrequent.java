package com.axonactive.programmingChallenges.chapter9;

import java.util.ArrayList;
import java.util.Scanner;

public class FindMostFrequent {
    public static int timesAppeared(char[] charArr) {
        int[] intArr = new int[charArr.length];

        //  every index in intArr represent for the times a character appeared.
        for (int i = 1; i < intArr.length; i++) {
            intArr[i] = 0;
        }

        // compare each character with others, if 2 value equal then increase 1
        for (int i = 0; i < charArr.length; i++) {
            for (int j = 1; j < charArr.length; j++) {
                if (Character.toLowerCase(charArr[i]) == Character.toLowerCase(charArr[j])){
                     intArr[j]++;
                }
            }
        }

        //TODO find max = most frequent character in the array, let alone the uppercase
        int max = intArr[0];

        // find most appeared times
        for (int i = 0; i < intArr.length; i++) {
            if (max < intArr[i]) {
                max = intArr[i];
            }
        }

        return max;
    }

    public static ArrayList<Character> mostFrequentChars(char[] charArr) {
        int[] times = new int[charArr.length];

        for (int i = 0; i < times.length; i++) {
            times[i] = 0;
        }

        for (int i = 0; i < charArr.length; i++) {
            for (int j = 1; j < charArr.length - 1; j++) {
                if (Character.toLowerCase(charArr[i]) ==
                        Character.toLowerCase(charArr[j])) {
                    times[j]++;
                }
            }
        }

        ArrayList<Integer> position = new ArrayList<>();
        int mostFrequent = timesAppeared(charArr);

        for (int i = 0; i < charArr.length; i++) {
            if (times[i] == mostFrequent) {
                position.add(i);
            }
        }
        ArrayList<Character> mostFrequentCharacters = new ArrayList<>();
        for (int i = 0; i < position.size(); i++) {
            mostFrequentCharacters.add(charArr[position.get(i)]);
        }

        return mostFrequentCharacters;
    }

    public static void mostFrequent(String str) {
        str = str.replaceAll("\\s+", "");
        char[] charArr = str.toCharArray();
        int mostFrequent = timesAppeared(charArr);

        // TODO show most frequent characters -- OK
        ArrayList<Character> mostFrequentCharacters = mostFrequentChars(charArr);


        // test to see what are in the array
        for (int i = 0; i < mostFrequentCharacters.size(); i++) {
            for (int j = 1; j < mostFrequentCharacters.size(); j++) {
                if (mostFrequentCharacters.get(i) == mostFrequentCharacters.get(j))
                    mostFrequentCharacters.remove(j);
            }
        }

        for (char element : mostFrequentCharacters) {
            System.out.println("Elements in array: " + element);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String strInput;

        System.out.print("Input a string: ");
        strInput = input.nextLine();


        mostFrequent(strInput);
    }
}
