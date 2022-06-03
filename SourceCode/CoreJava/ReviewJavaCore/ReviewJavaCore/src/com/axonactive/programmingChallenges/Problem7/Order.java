package com.axonactive.programmingChallenges.Problem7;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderID;
    private LocalDate orderDate;
    private List<OrderDetail> lineItems = new ArrayList<>();
    private int count;

    public Order() {
    }

    ;

    public Order(int orderID, LocalDate orderDate) {
        setOrderID(orderID);
        this.orderDate = orderDate;
    }

    public void addLineItem(Product item, int quantity) {
        lineItems.add(new OrderDetail(item, quantity));
    }

    public double calcTotalCharge() {
        double sum = 0;
        for (OrderDetail orderDetail :
                lineItems) {
            sum += orderDetail.calcTotalPrice();
        }

        return sum;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setLineItems(List<OrderDetail> lineItems) {
        lineItems = new ArrayList<>();
        this.lineItems = lineItems;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public List<OrderDetail> getLineItems() {
        return lineItems;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void printTable() {
        String tableFormat = "| %-11d | %-11s | %-15s | %-9.1f  | %-12d | %-12.1f |%n";

        System.out.println("ORDER ID: " + getOrderID());
        System.out.println("Date created: " + getOrderDate());

        System.out.format("+-------------+-------------+-----------------+------------+--------------+--------------+  %n");
        System.out.format("| ORDER       | ID          | DESCRIPTION     | PRICE      | QUANTITY     | TOTAL        |  %n");
        System.out.format("+-------------+-------------+-----------------+------------+--------------+--------------+  %n");

        for (int i = 0; i < lineItems.size(); i++) {
            System.out.format(tableFormat,
                    i + 1,  // ORDER
                    lineItems.get(i).getProduct().getProductID(), // ID
                    lineItems.get(i).getProduct().getDescription(), // DESCRIPTION
                    lineItems.get(i).getProduct().getPrice(), // PRICE
                    lineItems.get(i).getQuantity(), // QUANTITY
                    lineItems.get(i).calcTotalPrice()); // TOTAL
        }
        System.out.format("+-------------+-------------+-----------------+------------+--------------+--------------+  %n");

    }

    @Override
    public String toString() {
        printTable();
        return "Total charge: " + calcTotalCharge();
    }
}
