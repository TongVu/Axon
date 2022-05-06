package com.axonactive.programmingChallenges.PreferredCustomer;

import com.axonactive.programmingChallenges.PersonAndCustomer.Customer;

public class PreferredCustomer extends Customer {
    private double amountPurchase; // amountPurchase holds the amount of customer's purchase
    private double discountLevel; // discountLevel holds customer's discount level

    public PreferredCustomer() {
    }

    public PreferredCustomer(double amountPurchase) {
        setAmountPurchase(amountPurchase);
        setDiscountLevel();
    }

    public double getAmountPurchase() {
        return amountPurchase;
    }

    public void setAmountPurchase(double amountPurchase) {
        if (amountPurchase < 0) {
            throw new IllegalArgumentException(
                    "The amount of purchased need to be positive"
            );
        } else
            this.amountPurchase = amountPurchase;
    }

    public double getDiscountLevel() {
        return discountLevel;
    }

//-When customer spends $500, gets a 5% discount
//-When customer spends $1,000 gets 6% discount
//-When customer spends $1,500 gets 7% discount
//-When spends $2,000 or more, gest 10% discount
    public void setDiscountLevel() {
        if(amountPurchase < 500  ) this.discountLevel = 0;
        else if(amountPurchase < 1000 ) this.discountLevel = 5;
        else if(amountPurchase < 1500 ) this.discountLevel = 6;
        else if(amountPurchase < 2000 ) this.discountLevel = 7;
        else this.discountLevel = 10;
    }

    @Override
    public void showInfo(){
        super.showInfo();
        System.out.println("Amount purchase: $" + getAmountPurchase());
        System.out.println("Discount level: " + getDiscountLevel() + "%");
    }

}
