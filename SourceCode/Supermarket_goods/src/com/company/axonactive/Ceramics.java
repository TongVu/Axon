package com.company.axonactive;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Ceramics extends Goods implements SalesRate {
    private String manufacturer;
    private Date importedDate = Calendar.getInstance().getTime();

    public Ceramics(String id, String goodsName, double price, int stockUnit, String manufacturer) throws ParseException {
        super(id, goodsName, price, stockUnit);
        this.manufacturer = manufacturer;
    }

    public Ceramics(String id, String goodsName, double price, int stockUnit, String manufacturer, String importedDate) throws ParseException {
        super(id, goodsName, price, stockUnit);
        this.manufacturer = manufacturer;
        setImportedDate(importedDate);
    }

    public Ceramics() {
        this.importedDate = Calendar.getInstance().getTime();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getImportedDate() {
        return importedDate;
    }

    public void setImportedDate(String importedDate) throws ParseException {
        Date iDate = new SimpleDateFormat("dd/MM/yyyy").parse(importedDate);
        this.importedDate = iDate;
    }

    @Override
    public String toString() {
        return "Ceramics{\n" +
                super.toString() + "\n" +
                "manufacturer = " + manufacturer + "\n" +
                "importedDate = " + importedDate + "\n" +
                '}';
    }

    private boolean isDurationLargerThanTenDay() {
        int THIS_YEAR = Calendar.getInstance().get(Calendar.YEAR),
                THIS_MONTH = Calendar.getInstance().get(Calendar.MONTH),
                THIS_DAY = Calendar.DAY_OF_WEEK_IN_MONTH;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.importedDate);

        int productYear = calendar.get(Calendar.YEAR),
                productMonth = calendar.get(Calendar.MONTH),
                productDay = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);

        /*
            3 Lines below to test
         */
//        System.out.println(THIS_YEAR - productYear);
//        System.out.println(THIS_MONTH - productMonth);
//        System.out.println(THIS_DAY - productDay);

        if (THIS_YEAR > productYear) { // more than one year
            return true;

        } else if (THIS_MONTH > productMonth) {
            if(THIS_MONTH - productMonth > 1) return true; // more than 1 month
            else if ((THIS_DAY - 1) + (31 - productDay) >= 10) return true; // less than 30 days but 2 different months
            else return false;
        } else if (THIS_MONTH == productMonth) { //  less than 30 days
            if (THIS_DAY - productDay >= 10) return true;
            else return false;
        }

        return false;
    }

    @Override
    public String checkSalesRate() {
        if (getStockUnit() > 50 &&
                isDurationLargerThanTenDay()) {//AND nowTime - importedTime > 10
            return "Hard to sell";
        } else return "No rate";
    }
}
