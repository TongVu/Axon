package com.axonactive.programmingChallenges.chapter9;

import java.util.ArrayList;
import java.util.Scanner;

public class MiscellaneousStringOperations {
    public static int wordsCount(String str) {
        String[] tokens = str.split(" ");

        return tokens.length;
    }

    public static String arrayToStr(char[] charArray) {
        String str = String.valueOf(charArray);

        return str;
    }

    public static String replaceSubstring(String originalString, String strToSearch, String assignValue) {
        originalString = originalString.replace(strToSearch, assignValue);

        return originalString;
    }

    public static void mostFrequent(String str) {
        str = str.replaceAll("\\s+", "");
        char[] charArr = str.toCharArray();
        CharTimes[] charFrequency = new CharTimes[charArr.length];

        for (int i = 0; i < charArr.length; i++) {
            charFrequency[i] = new CharTimes();
            charFrequency[i].setCharacter(charArr[i]);
            charFrequency[i].setTimes(0);
        }

        for (int i = 0; i < charFrequency.length; i++) {
            for (int j = 0; j < charFrequency.length; j++) {
                if (charFrequency[i].getCharacter() == charFrequency[j].getCharacter()) {
                    charFrequency[j].setTimes(charFrequency[j].getTimes() + 1);
                }
            }
        }

        // find max
        int max = charFrequency[0].getTimes();

        for (int i = 0; i < charFrequency.length; i++) {
            if (max < charFrequency[i].getTimes()) {
                max = charFrequency[i].getTimes();
            }
        }

        ArrayList<CharTimes> maxArr = new ArrayList<>();
        for (int i = 0; i < charFrequency.length; i++) {
            if(max == charFrequency[i].getTimes()) maxArr.add(charFrequency[i]);
        }

        // TODO I mean to call the loop 2 times, not a mistake, take 1 loop then run the test as those strings below will show a minor bug.
        // i like tom and jerry
        // aaa bbb def
        // alien is real
        for (int i = 0; i < maxArr.size(); i++) {
            for (int j = 1; j < maxArr.size(); j++) {
                if (maxArr.get(i).getCharacter() == maxArr.get(j).getCharacter() && i != j)
                    maxArr.remove(j);
            }
        }
        for (int i = 0; i < maxArr.size(); i++) {
            for (int j = 1; j < maxArr.size(); j++) {
                if (maxArr.get(i).getCharacter() == maxArr.get(j).getCharacter() && i != j)
                    maxArr.remove(j);
            }
        }

        System.out.print("Most frequent character(s): [");
        for (CharTimes elm : maxArr) { System.out.print(elm.getCharacter() + " "); }
        System.out.println("\b]: with "+ max + " times");
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String strInput;

        System.out.print("Input a string: ");
        strInput = input.nextLine();

        System.out.println("COUNT WORDS ====================");
        System.out.println("Words in the string: " + wordsCount(strInput));

        System.out.println("\nCONVERT ARRAY OF CHARS TO STRING ====================");
        System.out.print("Let's input some characters for the char array: ");
        char[] charArr = input.nextLine().toCharArray();
        System.out.println("This is the string: " + arrayToStr(charArr));

        System.out.println("\nREPLACE SUBSTRING ====================");
        String wordSearch,
                wordChange,
                initialStr;

        System.out.print("Enter a string: ");
        initialStr = input.nextLine();
        System.out.print("Enter a word you want to search: ");
        wordSearch = input.nextLine();
        System.out.print("Enter a word that you want the previous word change into: ");
        wordChange = input.nextLine();
        System.out.println(replaceSubstring(initialStr, wordSearch, wordChange));


        // String test:
        // I like Tom and Jerry
        // AAA BBB DEFG
        // Alien is real
        // alien is real
        System.out.println("\nMOST FREQUENT CHARACTER ====================");
        System.out.print("Input a string: ");
        strInput = input.nextLine();
        mostFrequent(strInput);
    }
}
