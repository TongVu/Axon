package com.axonactive.programmingChallenges.chapter3;
import java.util.Scanner;

/*
    BMI = Weight x 703/ ( Height^2)
    BMI : _optimal if between 18.5 and 25
          _underweight if less than 18.5
          _overweight if more than 25
 */

public class BodyMassIndex {
    public static void main(String[] args) {
        double BMI,
                weight,
                height;

       Scanner input = new Scanner(System.in);

       System.out.print("What's your weight? (in pounds) : ");
       weight = input.nextDouble();

       System.out.print("What's your height? (in inches) : ");
       height = input.nextDouble();

       BMI = weight * 703 / ( height*height );
       if(BMI < 18.5){
           System.out.println("You're underweight");
       } else if(BMI >= 18.5 && BMI <= 25){
            System.out.println("Your BMI is optimal");
       } else{
            System.out.println("You're overweight");
        }
    }
}
