package com.axonactive.programmingChallenges.Problem5_CoffeeShop;

import java.util.Date;

// ITEM ID format in LL-XXXX with
// x is digit and L is letter

public abstract class SellingItem {
    private String itemId;
    private double itemCost;
    private int itemNum;
    private String description;

    private Date sellingDate;


    public SellingItem(){}

    public SellingItem(String itemId, double itemCost, int itemNum, String description, Date sellingDate) {
        if (checkId(itemId))
            this.itemId = itemId;

        if (itemCost <= 0)
            System.out.println("Item cost must be a positive");
        else
            this.itemCost = itemCost;

        if (itemNum >= 0 && itemNum <= 20)
            this.itemNum = itemNum;
        else System.out.println("Item number have to be in range 1 - 20");

        this.description = description;
        this.sellingDate = sellingDate;
    }

    private boolean checkId(String id) {
        if (id.matches("[a-zA-Z][a-zA-Z]-[0-9][0-9][0-9][0-9]")) return true;
        return false;
    }

    public Date getSellingDate() {
        return sellingDate;
    }

    public int getItemNum() {
        return itemNum;
    }

    public abstract double getPrice();

    public String getItemId() {
        return itemId;
    }

    public String getDescription() {
        return description;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setSellingDate(Date sellingDate) {
        this.sellingDate = sellingDate;
    }


    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String toString() {
        return "[ item id: " + getItemId() + "\n" +
                "Cost: $" + getItemCost() + " _ quantity: " + getItemNum() + "\n" +
                "Description: " + getDescription() +
                " ]";
    }

}
