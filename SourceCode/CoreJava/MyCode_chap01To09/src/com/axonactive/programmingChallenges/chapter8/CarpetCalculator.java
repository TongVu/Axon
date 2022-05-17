package com.axonactive.programmingChallenges.chapter8;

import java.util.Scanner;

/*
Application that calculates the price of carpeting for rectangular rooms.
-> areaOfTheFloor = width * length (square feet)
-> price = areaOfTheFloor * pricePerSquare  (dollars)
 */
public class CarpetCalculator {
    public static void main(String[] args) {
        double width, length, price;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the dimension of the room.");

        do{
            System.out.print("Enter the width(ft): ");
            width = input.nextDouble();
        }while(width < 0);

        do{
        System.out.print("Enter the length(ft): ");
        length = input.nextDouble();
        }while(length < 0);


        do{
            System.out.print("Enter the price per square feet that you desire: ");
            price = input.nextDouble();
        }while(price < 0);

        RoomDimension roomSpace = new RoomDimension(width, length);
        RoomCarpet roomNeedCarpeting = new RoomCarpet(roomSpace, price);

        System.out.println(roomSpace.toString());
        System.out.println(roomNeedCarpeting.toString());

    }
}
