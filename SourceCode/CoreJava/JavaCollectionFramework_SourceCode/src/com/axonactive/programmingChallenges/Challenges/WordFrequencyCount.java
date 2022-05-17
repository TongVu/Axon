package com.axonactive.programmingChallenges.Challenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This program allows user to open a specific file.
 * Prints a two-column table consisting of all the words in the file with the
 * number of times that each word appears.
 * <p>
 * Words are space-delimited and case-sensitive.
 */

public class WordFrequencyCount {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileInput = new Scanner(new File("Words.txt"));
        List<String> words = new LinkedList<>();

        while (fileInput.hasNext()) {
            StringTokenizer tokens = new StringTokenizer(fileInput.next(), ".,? \"");
            while (tokens.hasMoreTokens())
                words.add(tokens.nextToken());

        }


        Map<String, WordFrequency> abc = new HashMap<>();

        for (String word : words) {
            WordFrequency obj = new WordFrequency(word);
            abc.put(word, obj);
        }

        for (String word : words) {
            if(abc.containsKey(word))
                abc.get(word).increase();
        }


        abc.forEach((k, v) -> System.out.println(k + " _ " + v.getFrequency()));

    }
}
