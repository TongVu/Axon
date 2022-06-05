package problem1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Foods extends Goods implements SalesRate {
    private String manufacturer;
    private Date productionDate = Calendar.getInstance().getTime();
    private Date expiredDate = productionDate;

    public Foods(String id, String goodsName, double price, int stockUnit, String manufacturer, String productionDate, String expiredDate) throws ParseException {
        super(id, goodsName, price, stockUnit);
        this.manufacturer = manufacturer;
        setProductionDate(productionDate);
        setExpiredDate(expiredDate);
    }

    public Foods() {
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) throws ParseException {
        // check condition for productionDate input - not done
        Date pDate = new SimpleDateFormat("dd/mm/yyyy").parse(productionDate);
        this.productionDate = pDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) throws ParseException {
        // check condition for expiredDate input - not done
        Date eDate = new SimpleDateFormat("dd/mm/yyyy").parse(expiredDate);
        this.expiredDate = eDate;
    }

    @Override
    public String toString() {
        return "Foods{\n"  +
                super.toString() + "\n" +
                "manufacturer = " + manufacturer + "\n" +
                "productionDate = " + productionDate + "\n" +
                "expiredDate = " + expiredDate + "\n" +
                '}';
    }

    @Override
    public String checkSalesRate() {

        if (getStockUnit() > 0 ||
            getExpiredDate().before(Calendar.getInstance().getTime()) ){// and expiredDate < nowTime)
            return "Hard to sell";
        } else
            return "No rate";
    }
}
