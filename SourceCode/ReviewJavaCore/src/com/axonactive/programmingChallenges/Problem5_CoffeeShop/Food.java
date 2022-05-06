package com.axonactive.programmingChallenges.Problem5_CoffeeShop;

import java.util.Calendar;
import java.util.Date;

public class Food extends SellingItem {

    public Food(String itemId, double itemCost, int itemNum, String description, Date sellingDate) {
        super(itemId, itemCost, itemNum, description, sellingDate);
    }

    public double getPrice() {
        // check the date to see if it's in the weekends
        Date date = getSellingDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // if dayOfWeek == 1 or 7, that means it's weekends

        if (getItemNum() > 5) {
            return getItemCost() * 1.2 * 0.9;
        } else if (dayOfWeek == 1 ||
                dayOfWeek == 7) {
            return getItemCost() * 1.1 * 1.2;
        }

        return getItemCost() * 1.2;
    }

    public String toString() {
        return super.toString();
    }
}
