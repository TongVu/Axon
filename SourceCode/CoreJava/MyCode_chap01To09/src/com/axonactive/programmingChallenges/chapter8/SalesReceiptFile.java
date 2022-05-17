package com.axonactive.programmingChallenges.chapter8;
import com.axonactive.programmingChallenges.chapter6.RetailItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SalesReceiptFile {
    public static void main(String[] args) throws IOException {
        RetailItem item = new RetailItem("Addipure jacket", 1, 60);
        Scanner input = new Scanner(System.in);

        System.out.print("Quantity of items: ");
        CashRegister pos = new CashRegister(item, input.nextInt());

        PrintWriter fileToWrite = new PrintWriter("receipt.txt");


        fileToWrite.println("SALES RECEIPT");
        fileToWrite.printf("Unit Price: $%.2f\n", pos.getItemPrice());
        fileToWrite.println("Quantity: " + pos.getQuantity());
        fileToWrite.printf("Subtotal: %.2f\n", pos.getSubtotal());
        fileToWrite.printf("Sales Tax: $%.2f\n", pos.getTax());
        fileToWrite.printf("Total: $%.2f\n", pos.getTotal());
        fileToWrite.close();

        System.out.println("The customer's receipt has been printed. Please check it!");
    }
}
