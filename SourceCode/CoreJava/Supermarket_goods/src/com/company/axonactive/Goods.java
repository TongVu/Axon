package com.company.axonactive;

import java.util.Objects;
import java.util.Scanner;

public abstract class Goods implements SalesRate{
    private String id;
    private String goodsName;
    private double price;
    private int stockUnit;

    public Goods(String id, String goodsName, double price, int stockUnit) {
        this.id = id;
        setGoodsName(goodsName);
        setPrice(price);
        setStockUnit(stockUnit);
    }

    public Goods() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        Scanner input = new Scanner(System.in);
        do {
            if (goodsName.isBlank()) {
                System.out.print("Name can not be blank. Enter again: ");
                setGoodsName(input.nextLine());
            }
        } while (goodsName.isBlank());
        this.goodsName = goodsName;

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        Scanner input = new Scanner(System.in);
        do {
            if (price < 0) {
                System.out.print("price need to be larger than 0. Enter price: ");
                setPrice(input.nextDouble());
                input.nextLine();
            }
        } while (price < 0);
        this.price = price;
    }

    public int getStockUnit() {
        return stockUnit;
    }

    public void setStockUnit(int stockUnit) {
        Scanner input = new Scanner(System.in);

        do {
            if (stockUnit < 0) {
                System.out.print("Stock units need to be larger than 0. Enter units: ");
                setStockUnit(input.nextInt());
                input.nextLine();
            }
        } while (stockUnit < 0);
        this.stockUnit = stockUnit;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", stockUnit=" + stockUnit;
    }
    @Override
    public String checkSalesRate(){
        return null;
    };
}
