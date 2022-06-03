package com.axonactive.programmingChallenges.Problem7;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * This program allow user input product ID, description, price, quantity
 * then show the report of all the information above with total Charge for
 * each line item and total charge of all bill.
 */
public class Demo {
    public static void main(String[] args) {
        Order todayOrder = new Order();
        Scanner input = new Scanner(System.in);

        System.out.print("Order ID (ID is a number): ");
        todayOrder.setOrderID(input.nextInt());
        input.nextLine();

        LocalDate today = LocalDate.now();
        todayOrder.setOrderDate(today);

        String answer = "";
        do {
            System.out.print("Add line item? " +
                    "\n(y/n): ");
             answer = input.nextLine();

            if (answer.equalsIgnoreCase("y")) {
                Product newProduct = new Product();
                System.out.print("Product description: ");
                newProduct.setDescription(input.nextLine());

                System.out.print("Product id: ");
                newProduct.setProductID(input.nextLine());

                System.out.print("Price : $");
                newProduct.setPrice(input.nextDouble());
                input.nextLine();

                System.out.print("Quantity: ");
                int quantity = input.nextInt();
                input.nextLine();

                todayOrder.addLineItem(newProduct, quantity); // adding new items with quantity to the list

            } else System.out.println("STOP ADDING ITEM =============");
        } while(answer.equalsIgnoreCase("y"));

        System.out.println(todayOrder.toString()); // print bill
    }
}
