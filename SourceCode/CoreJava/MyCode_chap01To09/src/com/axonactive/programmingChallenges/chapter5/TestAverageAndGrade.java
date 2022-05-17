package com.axonactive.programmingChallenges.chapter5;

import java.util.Scanner;

/*

input: 5 test scores
output: display a letter grade for each score & average test score.

calcAverage: accept five test scores as arguments and return the average of the scores
determineGrade: accept a test score as an argument and return a letter grade for it

 */

public class TestAverageAndGrade {
    public static char determineGrade(double score) {
        char grade;
        if (score >= 90 && score <= 100) {
            grade = 'A';
        } else if (score >= 80 && score < 89) {
            grade = 'B';
        } else if (score >= 70 && score <= 79) {
            grade = 'C';
        } else if (score >= 60 && score < 69) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        return grade;
    }

    public static double calcAverage(double score1, double score2, double score3, double score4, double score5) {
        double avg = (score1 + score2 + score3 + score4 + score5) / 5;

        return avg;
    }

    public static void main(String[] args) {
        double score1, score2, score3, score4, score5;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter score 1: ");
        score1 = input.nextDouble();
        System.out.println(determineGrade(score1));

        System.out.print("Enter score 2: ");
        score2 = input.nextDouble();
        System.out.println(determineGrade(score2));

        System.out.print("Enter score 3: ");
        score3 = input.nextDouble();
        System.out.println(determineGrade(score3));

        System.out.print("Enter score 4: ");
        score4 = input.nextDouble();
        System.out.println(determineGrade(score4));

        System.out.print("Enter score 5: ");
        score5 = input.nextDouble();
        System.out.println(determineGrade(score5));

        System.out.println("The average score: " + calcAverage(score1, score2, score3, score4, score5));
    }
}
