package com.axonactive.programmingChallenges.chapter7;

/*
write a method accepts an array of Integer and a number n
display all numbers in the array that is larger than n
 */

import java.util.ArrayList;
import java.util.Scanner;

public class LargerThanN {
    private ArrayList<Integer> randomList = new ArrayList<>();

    public LargerThanN() {
    }

    public void setRandomList(int numb) {
        randomList.add(numb);
    }

    public void showLarger(int n) {
        ArrayList<Integer> largerThanN = new ArrayList<>();
        String numbers = "";

        for (int i = 0; i < randomList.size(); i++) {
            if (n < randomList.get(i)) {
                largerThanN.add(randomList.get(i));
            }
        }
        for (int i = 0; i < largerThanN.size(); i++) {
            numbers = numbers.concat(Integer.toString(largerThanN.get(i))).concat(" ");
        }

        System.out.println("The number larger than " + n + ": " + numbers);
    }

    public static void main(String[] args) {
        LargerThanN numbList = new LargerThanN();
        Scanner input = new Scanner(System.in);
        String numbOfList = " ";

        while (true) {
            System.out.print("To quit press q. Enter number to the list: ");
            numbOfList = input.nextLine();
            if (numbOfList.equals("q"))
                break;
            else
                numbList.setRandomList(Integer.parseInt(numbOfList));
        }

        int numbToCompare;
        System.out.print("What number do you want to compare with the numbers of the list? ");
        numbToCompare = input.nextInt();

        numbList.showLarger(numbToCompare);
    }
}
