package com.axonactive.programmingChallenges.chapter4;
import java.util.Scanner;
import java.util.Random;

public class RandomNumberGuessingGame {
    public static void main(String[] args) {
        int secretNum,
                guessedNum;
        Random ranNum = new Random();
        secretNum = ranNum.nextInt(20); // create a random number from range 0 to 20
        Scanner input = new Scanner(System.in);


        System.out.print("Guess a secret number from 0 to 20: ");
        guessedNum = input.nextInt();

        while(guessedNum != secretNum){
            if(guessedNum > secretNum) {
                System.out.print("Too high, try again: ");
                guessedNum = input.nextInt();
            } else if (guessedNum < secretNum) {
                System.out.print("Too low, try again: ");
                guessedNum = input.nextInt();
            }
        }
        if (guessedNum == secretNum){
            System.out.println("BINGO!!! The magic number isssss: " + secretNum);
        }
    }
}
