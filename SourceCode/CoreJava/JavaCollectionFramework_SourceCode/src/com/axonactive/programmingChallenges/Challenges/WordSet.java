package com.axonactive.programmingChallenges.Challenges;

import java.util.*;

public class WordSet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str;
        /*
         those words below to test
         apple Apple banana coconut watermelon kiwi banana jackfruit durian
         */

        System.out.print("Enter a string: ");
        str = input.nextLine();

        // Tokenizing the line of input
        StringTokenizer tokens = new StringTokenizer(str);// each token return a String

        // Adding each token to an appropriate set obj
        Set<String> sortedWordsSet = new TreeSet<>();

        // displays each unique word that was entered
        while (tokens.hasMoreTokens()) {
            sortedWordsSet.add(tokens.nextToken());
        }


        sortedWordsSet.iterator();
        Iterator<String> it;
        it = sortedWordsSet.iterator();
        // sorted in ascending order
        System.out.println("Sorted");
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
