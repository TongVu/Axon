package com.axonactive.problems.FileArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileArray {
    /*
        Contents of the array should be written to the file
        then the file should be closed
     */
    public static void writeArray(String nameOfFile, int[] arr) throws FileNotFoundException {
        File fileToWritten = new File(nameOfFile);
        PrintWriter printer = new PrintWriter(fileToWritten);

        for (int number :
                arr) {
            printer.println(number);
        }

        printer.close();
    }

    /*
        Read array: take two arguments: name of a file, reference to an int array
        The file should be opened, data should be read from the file, and stored in the array
        then the fiel should be closed
     */
    public static void readArray(String nameOfFile, ArrayList<Integer> arr) throws FileNotFoundException {
        Scanner fileReader = new Scanner(new File(nameOfFile));

        while (fileReader.hasNext())
            arr.add(fileReader.nextInt());

        fileReader.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        int[] arr = {
                3, 5, 6, 12, 36, 81, 39, 55,
                5, 7, 8, 8, 12, 99, 26, 35
        };

        writeArray("HelloWorld.txt", arr);

        ArrayList<Integer> newArr = new ArrayList<>();
        readArray("HelloWorld.txt", newArr);

        for (int number :
                newArr) {
            System.out.print(number + " -> ");
        }
        System.out.print("\b\b\b");
    }

}
