package com.axonactive.programmingChallenges.chapter8;
import com.axonactive.programmingChallenges.chapter6.RetailItem;

import java.util.Scanner;

public class CashRegister {
    private RetailItem item;
    private int quantity;


    public CashRegister(){
        this.item = new RetailItem("Addipure jacket", 1, 60);
    }

    public CashRegister(RetailItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public double getItemPrice(){
        return this.item.getPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal(){
       return this.quantity * this.item.getPrice();
    }

    public double getTax(){
        return getSubtotal() * 0.06; // tax rate is 6%
    }

    public double getTotal(){
        return getSubtotal() + getTax();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        RetailItem item = new RetailItem("Jacket", 1,  59.95);
        System.out.println("Item: " + item.getDescription());

        System.out.print("Enter the quantity of items: ");
        CashRegister pos = new CashRegister(item, input.nextInt());
        System.out.printf("Sale's subtotal: $%.2f", pos.getSubtotal());
        System.out.printf("\nSales tax: $%.2f", pos.getTax());
        System.out.printf("\nTotal: $%.2f", pos.getTotal());
    }
}
