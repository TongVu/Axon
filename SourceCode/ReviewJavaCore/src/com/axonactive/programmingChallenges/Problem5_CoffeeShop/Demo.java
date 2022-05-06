package com.axonactive.programmingChallenges.Problem5_CoffeeShop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Ask for help with Date type
 */
public class Demo {
    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        int items = 0;

        do {
            if(items < 0 || items > 100) System.out.println("INVALID ITEMS NUMBER");
            System.out.print("How many items? ");
            items = input.nextInt();
            input.nextLine();
        }while(items < 0 || items > 100 );

        List<SellingItem> itemsList = new ArrayList<>();

        for (int i = 0; i < items; i++) {
            String choice;

            System.out.println("1.Food || 2.Drink || 3.Other");
            System.out.print("Enter your choice: ");
            choice = input.nextLine();

            if (!choice.equals("1") &&
                    !choice.equals("2") &&
                    !choice.equals("3")) {
                System.out.println("Maybe you've typed wrong number!");
                break;
            }

            String itemId,
                    description,
                    date;
            double cost = 0;
            int quantity;

            System.out.println("Format: LL-XXXX. L is letter, X is digit");
            System.out.print("Item ID: ");
            itemId = input.nextLine();

            System.out.print("Cost: ");
            cost = input.nextDouble();
            input.nextLine();

            System.out.print("Quantity: ");
            quantity = input.nextInt();
            input.nextLine();

            System.out.print("Description: ");
            description = input.nextLine();

            System.out.print("Selling date (dd/mm/yyyy): ");
            date = input.nextLine();

            Date sellingDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);

            if (choice.equals("1")) {
                System.out.println("ADDING FOOD TO THE LIST");
                SellingItem item =
                        new Food(itemId, cost, quantity, description, sellingDate);
                itemsList.add(item);

            } else if (choice.equals("2")) {
                System.out.println("ADDING DRINK TO THE LIST");
                SellingItem item =
                        new Drink(itemId, cost, quantity, description, sellingDate);
                itemsList.add(item);

            } else if (choice.equals("3")) {
                System.out.println("ADDING OTHER TO THE LIST");
                SellingItem item =
                        new Other(itemId, cost, quantity, description, sellingDate);
                itemsList.add(item);

            }
        }

        double maxPrice = itemsList.get(0).getPrice();
        System.out.println("price: " + itemsList.get(0).getPrice());

        double totalPrice = itemsList.get(0).getPrice();

        for (int i = 1; i < itemsList.size(); i++) {
            if (maxPrice < itemsList.get(i).getPrice()) maxPrice = itemsList.get(i).getPrice();
            totalPrice += itemsList.get(i).getPrice();
        }
        System.out.println("MAX PRICE: " + maxPrice);
        System.out.println("AVERAGE PRICE: " + totalPrice / itemsList.size());

    }
}
