package com.axonactive.programmingChallenges.chapter4;
import java.util.Scanner;
import java.io.*;

public class LineNumbers {
    public static void main(String[] args) throws IOException
    {
        String nameOfFile;
        Scanner input = new Scanner(System.in);


        System.out.print("Please input the name of file (the file name must include extension part): ");
        nameOfFile = input.nextLine();

        //CREATE A FILE OBJECT AND PASS A VALUE TO IT
        File fileToRead = new File(nameOfFile);
        Scanner inputFile = new Scanner(fileToRead);

        for (int i = 1; inputFile.hasNext() ; i++){
            String textLines = inputFile.nextLine();
            System.out.println("Line " + i + ": " + textLines);
        }
        inputFile.close();
    }
}
