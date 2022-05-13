package com.axonactive.programmingChallenges.problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class findMax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String number1,
                number2;

        System.out.print("Input number 1: ");
        number1 = input.nextLine();
        char[] number1Arr;
        number1Arr = number1.toCharArray();

        int max1 = Character.getNumericValue(number1Arr[0]) ;
        for (int i = 1; i < number1Arr.length; i++) {
            if(max1 < Character.getNumericValue(number1Arr[i]) ){
                max1 = Character.getNumericValue(number1Arr[i]);
            }
        }

        System.out.print("Input number 2: ");
        number2 = input.nextLine();
        char[] number2Arr;
        number2Arr = number2.toCharArray();

        int max2 = Character.getNumericValue(number2Arr[0]) ;
        for (int i = 1; i < number2Arr.length; i++) {
            if(max2 < Character.getNumericValue(number2Arr[i]) ){
                max2 = Character.getNumericValue(number2Arr[i]);
            }
        }

        int max = max1 < max2 ? max2 : max1;
        System.out.println("Max number: "  + max);
    }
}
