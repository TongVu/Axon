package com.company.axonactive;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ceramics extends Goods implements SalesRate{
    private String manufacturer;
    private Date importedDate;

    public Ceramics(String id, String goodsName, double price, int stockUnit, String manufacturer, String importedDate) throws ParseException {
        super(id, goodsName, price, stockUnit);
        this.manufacturer = manufacturer;
        setImportedDate(importedDate);
    }

    public Ceramics() {
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
        // check condition for importedDate input - not done
        Date iDate = new SimpleDateFormat("dd/mm/yyyy").parse(importedDate);
        this.importedDate = iDate;
    }

    @Override
    public String toString() {
        return "Ceramics{" + super.toString() +
                " manufacturer='" + manufacturer + '\'' +
                ", importedDate=" + importedDate +
                '}';
    }

    @Override
    public String checkSalesRate() {
       if(getStockUnit()>50 ){//AND nowTime - importedTime > 10
           return "Hard to sell";
       }
       else return "No rate";
    }
}
