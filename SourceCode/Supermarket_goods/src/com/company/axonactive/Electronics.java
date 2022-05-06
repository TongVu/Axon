package com.company.axonactive;

import java.util.Scanner;

public class Electronics extends Goods implements SalesRate{
    private double warranty;
    private double power;

    public Electronics(String id, String goodsName, double price, int stockUnit, double warranty, double power) {
        super(id, goodsName, price, stockUnit);
        this.warranty = warranty;
        this.power = power;
    }

    public Electronics() {
    }

    public double getWarranty() {
        return warranty;
    }

    public void setWarranty(double warranty) {
        Scanner input = new Scanner(System.in);
        do {
            if (warranty < 0) {
                System.out.print("Warranty need to be larger than 0. Enter warranty: ");
                setWarranty(input.nextDouble());
                input.nextLine();
            }
        } while (warranty < 0);
        this.warranty = warranty;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Electronics{" + super.toString() +
                " warranty=" + warranty +
                ", power=" + power +
                '}';
    }

    @Override
    public String checkSalesRate() {
       if(getStockUnit()<3){
           return "Sell well";
       }
       else return "No rate";
    }
}
