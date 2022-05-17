package com.axonactive.programmingChallenges.chapter2;
import java.util.Scanner;

public class WordGame {

    public static void main(String[] args) {
        String name, age, city, profession, college, animal,
                animalName;
        Scanner input = new Scanner(System.in);

        System.out.print("Your name: ");
        name = input.nextLine();

        System.out.print("Your age ");
        age = input.nextLine();

        System.out.print("Your profession ");
        profession = input.nextLine();

        System.out.print("Your college ");
        college = input.nextLine();

        System.out.print("Your animal ");
        animal = input.nextLine();

        System.out.print("Your city ");
        city = input.nextLine();

        System.out.print("Your pet's name ");
        animalName = input.nextLine();
        System.out.println("There once a person named " + name + " who lived in " + city + ". At the age of " + age +",");
        System.out.println(name + " went to college at " + college + " graduated and went to work as a");
        System.out.println(profession + ".Then " + name + " adopted a " + animal + " named");
        System.out.println(animalName + ". They both lived happily after ever.");
    }
}
