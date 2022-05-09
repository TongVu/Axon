package com.axonactive.programmingChallenges.chapter2;
import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner usrInput = new Scanner(System.in);
        String favoriteCity;

        System.out.print("What's your favorite city? ");
        favoriteCity = usrInput.nextLine();

        System.out.println("Number of characters: " + favoriteCity.length());
        System.out.println("Upper case: "+ favoriteCity.toUpperCase());
        System.out.println("Lower case: " + favoriteCity.toLowerCase());
        System.out.println("First character: " + favoriteCity.charAt(0));
    }
}
