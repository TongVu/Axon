package com.axonactive.programmingChallenges.chapter3;
import java.util.Scanner;

public class TestScoresAndGrade {
    public static void main(String[] args) {

        double test1, test2, test3;
        Scanner input = new Scanner(System.in);

        System.out.print("Score 1 : ");
        test1 = input.nextDouble();

        System.out.print("Score 2 : ");
        test2 = input.nextDouble();

        System.out.print("Score 3 : ");
        test3 = input.nextDouble();

        double avg = ( test1 + test2 + test3) / 3;
        System.out.println("Your average scores: " + avg);

        if(avg >= 90 && avg <=100) {
            System.out.println("A");
        }else if(avg >= 80 && avg<= 89) {
            System.out.println("B");
        }else if (avg >= 70 && avg <= 79){
            System.out.println("C");
        }else if (avg >= 60 && avg <= 69){
            System.out.println("D");
        }else {
            System.out.println("F");
        }
    }
}
