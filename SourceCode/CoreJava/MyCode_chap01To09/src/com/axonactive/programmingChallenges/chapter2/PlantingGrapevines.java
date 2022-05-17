package com.axonactive.programmingChallenges.chapter2;
import java.util.Scanner;

/*
    v: numberOfGrapevines = (R: length - 2  * E: endSpace) / S : space between vines
 */
public class PlantingGrapevines {
    public static void main(String[] args) {

        double lengthOfRow, endSpace, spaceBetween, numberOfGrapevines;
        Scanner input = new Scanner(System.in);

        System.out.print("Length per row: ");
        lengthOfRow = input.nextDouble();

        System.out.print("Space used by an end-post: ");
        endSpace = input.nextDouble();

        System.out.print("Space between vines: ");
        spaceBetween = input.nextDouble();

        numberOfGrapevines = (int)((lengthOfRow - 2 * endSpace) / spaceBetween);
        System.out.println("Number of grapevines: " + numberOfGrapevines);

    }
}
