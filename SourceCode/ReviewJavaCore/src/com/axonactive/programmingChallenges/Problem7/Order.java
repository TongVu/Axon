package com.axonactive.programmingChallenges.Problem7;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    private int orderID;
    private LocalDate orderDate;
    private ArrayList<OrderDetail> lineItems;
    private int count;

    public Order(int orderID, LocalDate orderDate) {
        this.orderID = orderID;
        this.orderDate = orderDate;
    }

    public void addLineItem(Product item, int quantity) {
        lineItems.add(new OrderDetail(item, quantity));
    }

    public double calcTotalCharge() { //
        return 0.0d;
    }

    public int getOrderID() {
        return orderID;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public ArrayList<OrderDetail> getLineItems() {
        return lineItems;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Sout something here";
    }


}
