package com.axonactive.programmingChallenges.Problem1_SmartPhoneManagement;

import java.util.Date;

public class SmartPhone implements Comparable<SmartPhone>{
    private String id;
    private String manufacturer;


    private double price;
    private String date;
    private String description;


    public SmartPhone(){}

    public SmartPhone(String ID,
                      String manufacturer,
                      double price,
                      String date,
                      String description){
        setId(ID);
        setManufacturer(manufacturer);
        setPrice(price);
        setDate(date);
        setDescription(description);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int compareTo(SmartPhone smartPhone){
        return (int)(this.getPrice() - smartPhone.getPrice());
    }

    @Override
    public String toString(){
        return "Phone id: " + this.id +
                "\nManufacturer: " + this.manufacturer +
                "\nPrice: " + this.price +
                "\nDate: " + this.date +
                "\n_[ " + this.description + " ]";
    }
}
