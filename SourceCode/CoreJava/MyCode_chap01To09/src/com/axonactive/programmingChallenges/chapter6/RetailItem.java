package com.axonactive.programmingChallenges.chapter6;

public class RetailItem {
    private String description;
    private int unitsOnHand;
    private double price;

    public RetailItem(){}
    public RetailItem(String description, int unitsOnHand, double price) {
        this.description = description;
        this.unitsOnHand = unitsOnHand;
        this.price = price;
    }

    public void setDescription(String description) {
        description = description;
    }

    public void setUnitsOnHand(int units) {
        unitsOnHand = units;
    }

    public void setPrice(double priceVal) {
        price = priceVal;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        RetailItem item1, item2, item3;

        item1 = new RetailItem();
        item1.setDescription("Jacket");
        item1.setUnitsOnHand(12);
        item1.setPrice(59.95);

        item2 = new RetailItem();
        item2.setDescription("Jacket");
        item2.setUnitsOnHand(12);
        item2.setPrice(59.95);

        item3 = new RetailItem();
        item3.setDescription("Jacket");
        item3.setUnitsOnHand(12);
        item3.setPrice(59.95);
    }
}
