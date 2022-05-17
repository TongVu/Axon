package com.axonactive.programmingChallenges.chapter6;

import java.util.Scanner;

public class TestScores {
    private double testScore1, testScore2, testScore3;


    public double getTestScore1() {
        return testScore1;
    }

    public double getTestScore2() {
        return testScore2;
    }

    public double getTestScore3() {
        return testScore3;
    }

    public void setTestScore1(double score1) {
        testScore1 = score1;
    }

    public void setTestScore2(double score2) {
        testScore2 = score2;
    }

    public void setTestScore3(double score3) {
        testScore3 = score3;
    }

    public double average() {
        return (testScore1 + testScore2 + testScore3) / 3;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TestScores yourTest = new TestScores();

        System.out.print("Enter test score 1: ");
        yourTest.setTestScore1(input.nextDouble());

        System.out.print("Enter test score 2: ");
        yourTest.setTestScore2(input.nextDouble());

        System.out.print("Enter test score 3: ");
        yourTest.setTestScore3(input.nextDouble());

        System.out.printf("Your average Test score is: %.2f", yourTest.average());
    }
}
