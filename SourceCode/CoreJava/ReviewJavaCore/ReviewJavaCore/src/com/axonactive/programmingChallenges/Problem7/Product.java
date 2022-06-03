package com.axonactive.programmingChallenges.Problem7;

public class Product {
    private String description;
    private String productID;
    private double price;


    public Product(){}

    public Product(String description, String productID, double price) {
        this.description = description;
        this.productID = productID;
        setPrice(price);
    }

    public String getDescription() {
        return description;
    }

    public String getProductID() {
        return productID;
    }

    public double getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setPrice(double price) {
        while(price < 0){
            System.out.print("Price have to be larger than 0. Enter again: ");
            setPrice(price);
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "[ Description : " + description + "\n" +
                "Product ID: " + productID + "\n" +
                "Price: $" + price + " ]\n";
    }

}
