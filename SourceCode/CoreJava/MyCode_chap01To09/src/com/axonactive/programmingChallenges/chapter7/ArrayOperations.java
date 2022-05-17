package com.axonactive.programmingChallenges.chapter7;

import java.util.ArrayList;
import java.util.Scanner;

/*
getTotal( Array[anyType] ) _> return total of the values in array
getAverage( Array[anyType] ) _> return average of the values in the array
getHighest ( Array[anyType] ) _> return highest values
getLowest ( Array[anyType] ) _> return lowest
 */
public class ArrayOperations {
    private ArrayList<Integer> listNumb = new ArrayList<>();

    public ArrayOperations() {
    }

    public void setList(){
        Scanner input = new Scanner(System.in);
        String numbOfList;

        while (true) {
            System.out.print("To quit press q. Enter number to the list: ");
            numbOfList = input.nextLine();
            if (numbOfList.equals("q"))
                break;
            else
                listNumb.add(Integer.parseInt(numbOfList));
        }
    }

    public void showVal(){
        for (int i = 0; i < listNumb.size(); i++) {
            System.out.print(listNumb.get(i) + " ");
        }
    }
    public int getSize(){
        return listNumb.size();
    }

    public int getTotal() {
        int total = 0;
        for (int i = 0; i < listNumb.size(); i++) {
            total += listNumb.get(i);
        }
        return total;
    }

    public double getAvg() {
        return ((double) getTotal()) / listNumb.size();
    }

    public int getHighest() {
        int highest = listNumb.get(0);

        for (int i = 0; i < listNumb.size(); i++) {
            if (highest < listNumb.get(i)) {
                highest = listNumb.get(i);
            }
        }

        return highest;
    }

    public int getLowest() {
        int lowest = listNumb.get(0);

        for (int i = 0; i < listNumb.size(); i++) {
            if (lowest > listNumb.get(i)) {
                lowest = listNumb.get(i);
            }
        }

        return lowest;
    }

    public static void main(String[] args) {
        ArrayOperations list = new ArrayOperations();
        list.setList();
        System.out.println("========================================");
        System.out.println("Your list: ");
        list.showVal();
        System.out.println("\n========================================");
        System.out.println("Total: " + list.getTotal());
        System.out.printf("Average: %.4f\n" , list.getAvg());
        System.out.println("Highest value: " + list.getHighest());
        System.out.println("Lowest value: " + list.getLowest());
    }
}
