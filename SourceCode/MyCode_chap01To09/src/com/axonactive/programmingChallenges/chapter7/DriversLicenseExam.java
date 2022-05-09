package com.axonactive.programmingChallenges.chapter7;

// correct answers need to be from 15 or above

import java.util.Arrays;
import java.util.Scanner;

public class DriversLicenseExam {

    public static void main(String[] args) {

        int TOTAL_ANSWERS = 20;
        String[] usrAnswers = new String[20];
        Arrays.fill(usrAnswers, ""); // assigns empty value to all array elements
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your answers (a,b,c,d)");
        for (int i = 0; i < TOTAL_ANSWERS; i++) {
            System.out.print((i + 1) + ":");
            usrAnswers[i] = input.nextLine();
        }

        DriverExam exam = new DriverExam();
        System.out.println("Your correct answers: " + exam.totalCorrect(usrAnswers));
        System.out.println("Your incorrect answers: " + exam.totalIncorrect(usrAnswers));
        System.out.println("Questions that you've missed: " + exam.totalIncorrect(usrAnswers));
        System.out.println("==================================================");
        if (exam.passed(usrAnswers))
            System.out.println("Your resuls is passed");
        else
            System.out.println("Your resuls is failed");
    }
}
