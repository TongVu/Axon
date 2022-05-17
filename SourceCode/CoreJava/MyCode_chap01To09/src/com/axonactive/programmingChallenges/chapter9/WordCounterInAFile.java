package com.axonactive.programmingChallenges.chapter9;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordCounterInAFile {
    public static void main(String[] args) throws IOException {
        String fileName;
        Scanner input = new Scanner(System.in);

        // get file name - in this case I use "fileToTest.txt" to work with
        System.out.println("What's the file name: ");
        fileName = input.nextLine();

        File fileToRead = new File(fileName);
        Scanner file = new Scanner(fileToRead);
        // read file and pass it value to dataFromFile
        StringBuilder dataFromFile= new StringBuilder();

        while(file.hasNext()){
            dataFromFile = dataFromFile.append(file.nextLine());
        }
        file.close();

        // Because the file have some words join consecutively with the dot.
        // I use this to separate them.
        String str = dataFromFile.toString();
        String[] tokens = str.split("\\.");

        // Now I join them without the dot. I still got the whole file's content
        StringBuilder newStr = new StringBuilder();
        for (String token : tokens) {
            newStr = newStr.append(token).append(" ");
        }

        // Use split again to count them.
        String[] words = newStr.toString().split(" ");
        System.out.println("Total words in the file: " + words.length);
    }
}
