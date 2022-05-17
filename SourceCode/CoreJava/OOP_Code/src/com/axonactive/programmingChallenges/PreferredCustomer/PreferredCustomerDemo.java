package com.axonactive.programmingChallenges.PreferredCustomer;

/*

Customers can earn discounts on all their purchases.

The amount of a customer's discount is determined
by the customer's cumulative purchases in the store as follow:

-When customer spends $500, gets a 5% discount
-When customer spends $1,000 gets 6% discount
-When customer spends $1,500 gets 7% discount
-When spends $2,000 or more, gest 10% discount

 */

import com.axonactive.programmingChallenges.PersonAndCustomer.Customer;

public class PreferredCustomerDemo {
    public static void main(String[] args) {
        PreferredCustomer customer = new PreferredCustomer(2000);
        customer.setName("Tong");
        customer.setAddress("Ho Chi Minh city");
        customer.setPhoneNumber("0972.xxx.777");
        customer.setCustomerNumber("AXON-AAA");
        customer.setOnMailList(true);

        customer.showInfo();
    }

}
