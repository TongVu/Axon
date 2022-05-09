package com.axonactive.programmingChallenges.chapter5;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PrimeNumberList {
    public static boolean isPrime(int numbCheck) {
        if (numbCheck <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(numbCheck); i++) {
            if (numbCheck % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        PrintWriter fileToImport = new PrintWriter(
                new FileWriter("prime_number_list.txt", true));
        boolean checkPrime;

        for (int i = 0; i < 100; i++) {
            checkPrime = isPrime(i);
            if (checkPrime) {
                fileToImport.print(i + " - ");
            }
        }
        System.out.println("File import is completed");
        fileToImport.close();
    }
}
